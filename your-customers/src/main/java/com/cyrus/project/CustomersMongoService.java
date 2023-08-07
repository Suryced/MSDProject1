package com.cyrus.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersMongoService implements CustomersService {

	@Autowired 
	CustomersMongoRepository mongoRepository;

	@Override
	public void loadData() {
		Customer event1 = new Customer("Michael Jackson", "mj@heehee.com", "sm00thcriminal");
		Customer event2 = new Customer("Edmond Dantes", "vengence@montecristo.com", "revengeIsSweet");
		Customer event3 = new Customer("Bruce Wayne", "bruce@wayneindustries.com", "b@tm@n");
		mongoRepository.save(event1);
		mongoRepository.save(event2);
		mongoRepository.save(event3);
	}
	
	@Override
	public List<Customer> findAllCustomers() {
		return mongoRepository.findAll();
	}
	
	@Override
	public Optional<Customer> findCustomerById(String id) {
		return mongoRepository.findById(id);
	}
	
	@Override
	public void deleteCustomerById(String id) {
		mongoRepository.deleteById(id);
	}
	
	@Override
	public void deleteCustomer(Customer customer)
	{
		mongoRepository.delete(customer);
	}
	
	@Override
	public Customer saveOrUpdate(Customer customer)
	{
		return mongoRepository.save(customer);
	}
	
	
}
