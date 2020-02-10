package by.htp.shymko.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.htp.shymko.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	private final int pageSize = 4;

	@Autowired
	private SessionFactory sessionFactory;
			

	public List<Customer> getCustomers(int page) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		    Query query = currentSession.createQuery("from Customer order by firstName",  Customer.class);
		    query.setFirstResult((page * pageSize)-(pageSize-1));
		    query.setMaxResults(pageSize);

		    return query.list();
		}
	

	public int getCountCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query countQuery = currentSession.createQuery("Select count(*) FROM Customer");
		Long countResults = (Long) countQuery.uniqueResult();
		int lastPageNumber = (int) (Math.ceil(countResults / (pageSize /1.0)));
		
		System.out.println(countResults);
		System.out.println(lastPageNumber);
			
		return lastPageNumber;
	}
		

	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();		
	}

	public Customer findByLogin(String login) {
		Session currentSession = sessionFactory.getCurrentSession();
	
		Query<Customer> query = currentSession.createQuery("from Customer where login = :login", Customer.class);
        query.setParameter("login", login);
        return query.list().stream().findAny().orElse(null);
	}

}