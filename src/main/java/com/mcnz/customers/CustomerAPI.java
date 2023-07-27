package com.mcnz.customers;

import java.util.ArrayList;
import java.util.Collection;

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
	
	static ArrayList<Customer> list = new ArrayList<>();
	
	static {
		list.add(new Customer(1L, "Bruce", "pass", "bruce@a.com"));
		list.add(new Customer(2L, "Paul", "pass", "paul@b.com"));
		list.add(new Customer(3L, "Rick", "pass", "rick@c.com"));
		list.add(new Customer(4L , "Cameron", "123456", "cameron@mcnz.com"));
		list.add(new Customer(6L, "Curtis", "abcdefg", "curtis@example.com"));
		list.add(new Customer(7L, "andy@gmail.com", null, "andy"));
		list.add(new Customer(8L , "Aaron", null, "Aaron@example.com"));
		list.add(new Customer(9L, "nn", "rr", "aa"));
		list.add(new Customer(11L, "Jake", "pass", "jblatt@wowway.com"));
		list.add(new Customer(12L, "Test", "passtest", "test@test.com"));
	}

	@GetMapping
	public Collection<Customer> register(Customer customer)
	{
		return list;
	}
	
//	@GetMapping("/api/customers/{name}")
//	public String getCustomerByName(@PathVariable String name) {
//		return name;
//	}
//	
//	@PutMapping("/api/customers/update/{name}")
//	public String putCustomer(@PathVariable String name) {
//		return "Updated";
//	}
//		
//	@DeleteMapping("api/customers/delete/{name}")
//	public String deleteCustomer(@PathVariable String name) {
//		return "deleted";
//	}
	
	@PostMapping("/byname")
	public Customer byNameCustomer(String name)
	{
		for (Customer c: list)
		{
			if (c.getName() == name)
			{
				return c;
			}
		}
		return null;
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> byIdCustomer(@RequestBody Customer customer, @PathVariable("customerId") Long id) {
		for (Customer c : list)
		{
			if (c.getId() == id)
			{
				c = customer;
				return ResponseEntity.ok().build();
			}
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Long id ) {
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
