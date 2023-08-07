package com.cyrus.project;

import java.util.List;
import java.util.Optional;

public interface CustomersService {

	void loadData();

	List<Customer> findAllCustomers();

	Optional<Customer> findCustomerById(String id);

	void deleteCustomerById(String id);

	void deleteCustomer(Customer customer);

	Customer saveOrUpdate(Customer customer);

}