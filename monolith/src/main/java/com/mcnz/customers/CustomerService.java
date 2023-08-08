package com.mcnz.customers;

import java.util.List;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomerById(int id);
	
	public void addCustomer(Customer newCustomer);
	
	public void deleteCustomer(int id);

	void updateCustomer(Customer newCustomer);
	
}
