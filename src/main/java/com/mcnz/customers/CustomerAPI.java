package com.mcnz.customers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerAPI {

	@GetMapping("/api/customers")
	public Collection<Customer> register(Customer customer)
	{
		ArrayList<Customer> list = new ArrayList<>();

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
		return list;
	}
	
}
