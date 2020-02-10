package by.htp.shymko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.shymko.dao.CustomerDAO;
import by.htp.shymko.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public List<Customer> getCustomers(int page) {
		return customerDAO.getCustomers(page);
	}
	
	@Transactional
	public int getCountCustomers() {
		return customerDAO.getCountCustomers();
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		theCustomer.setPassword(passwordEncoder.encode(theCustomer.getPassword()));
		customerDAO.saveCustomer(theCustomer);
	}

	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Transactional
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);
	}

	@Transactional
	public Customer findByLogin(String login) {

		return customerDAO.findByLogin(login);
	}

}
