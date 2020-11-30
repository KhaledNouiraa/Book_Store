package org.polytec.vermeg.service;

import java.util.List;

import org.polytec.vermeg.dao.CustomerDAO;

import org.polytec.vermeg.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDAO custDao ;
	
	@Transactional
	public List<Customer> getAllCustomers() {
		return custDao.getCustomers();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return custDao.getCustomer(id);
	}
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		custDao.saveCustomer(theCustomer);
	}
	
	

	@Transactional
	public void deleteCustomer(int theId) {
		
		custDao.deleteCustomer(theId);
	}
}