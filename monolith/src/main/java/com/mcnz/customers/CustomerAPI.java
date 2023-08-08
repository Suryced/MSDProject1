package com.mcnz.customers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerAPI {
	
	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}
	
	@PostMapping
	public ResponseEntity<?> setCustomers(List<Customer> list)
	{
		if (list.isEmpty())
			return ResponseEntity.badRequest().build();
		for (Customer c : list)
		{
			customerService.addCustomer(c);
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/byname")
	public Customer byNameCustomer(@RequestBody String name)
	{
		List<Customer> list = getCustomers();
		for (Customer c: list)
		{
			if (c.getName().equals(name))
			{
				System.out.println(name);
				return c;
			}
			else
			{
				System.out.println(c.getName() + " not equal to " + name);
			}
		}
		System.out.println("Name " + name + " not found!");
		return null;
	}
	
	@GetMapping("/byname/{username}")
	public Customer byNameUsername(@PathVariable("username") String username) 
	{
		List<Customer> list = getCustomers();
		for (Customer c : list)
		{
			if (c.getName().equals(username)) {
				return c;
			}
		}
		return null;
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> byIdCustomer(@RequestBody Customer customer, @PathVariable("customerId") int id) {
		List<Customer> list = getCustomers();
		try {
			Customer c = customerService.getCustomerById(id);
			if (c != null) {
				customerService.updateCustomer(customer);
				return ResponseEntity.ok().build();
			}else {
				customerService.addCustomer(customer);
				return ResponseEntity.ok().build();
			}
		}catch(Exception e) {
		return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int id ) {
		List<Customer> list = getCustomers();
		for (Customer c : list)
		{
			if (c.getId() == id)
			{
				list.remove(c);
				return ResponseEntity.ok().build();
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
}
