package by.htp.shymko.dao;

import java.util.List;

import by.htp.shymko.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers(int page);
	
	public int getCountCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

	public Customer findByLogin(String login);

}
