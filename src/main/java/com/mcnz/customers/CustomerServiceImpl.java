package com.mcnz.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> list = List.copyOf(customerDAO.getAllCustomers());
		return list;
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	public void addCustomer(Customer newCustomer) {
		customerDAO.saveCustomer(newCustomer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
	}
	
}
