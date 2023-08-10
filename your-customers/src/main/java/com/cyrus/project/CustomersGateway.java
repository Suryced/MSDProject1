package com.cyrus.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
//@RequestMapping("/api")
public class CustomersGateway {

	@Autowired
	CustomersService customersService;


	@GetMapping("/loaddata")
	public void loadData() {
		customersService.loadData();
	}
	
	@GetMapping("/customers")
	public List<Customer> findAllCustomers() {
		return customersService.findAllCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Optional<Customer> findCustomerById(@PathVariable("id") String id) {
		return customersService.findCustomerById(id);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomerById(@PathVariable("id") String id) {
		customersService.deleteCustomerById(id);
	}
	
	@PostMapping("/customers")
	public Customer create(@RequestBody Customer customer)
	{
		System.out.println("In Post for Customer " + customer.getName());
		return customersService.saveOrUpdate(customer);
	}
	
	@PutMapping("/customers/{id}")
	public Customer update(@RequestBody Customer event)
	{
		return create(event);
	}
	
}
