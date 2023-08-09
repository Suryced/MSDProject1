package com.cyrus.project;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomersClientGateway {

	@GetMapping("/api/customers")
	public List<Customer> getAll() {
		RestTemplate rt = new RestTemplate();
		List customers = rt.getForObject(
				"http://localhost:8012/customers", 
				List.class);
		System.out.println(customers);
		return customers;
		
	}
	
	@GetMapping("/api/customers/{id}")
	public Customer getById(@PathVariable String id) {
		RestTemplate rt = new RestTemplate();
		Customer customer = rt.getForObject(
				"http://localhost:8012/customers/" + id, 
				Customer.class);
		System.out.println(customer);
		return customer;
	}
	
	@DeleteMapping("/api/customers/{id}")
	public void deleteById(@PathVariable String id)
	{
		RestTemplate rt = new RestTemplate();
		rt.delete("http://localhost:8012/customers/" + id);
	}
	
	@PostMapping("/customers")
	public Customer create(@RequestBody Customer customer)
	{
		RestTemplate rt = new RestTemplate();
		customer = rt.postForObject("http://localhost:8012/customers/", customer, Customer.class);
		return customer;
	}
	
	@PutMapping("/customers/{id}")
	public Customer update(@RequestBody Customer customer, @PathVariable String id)
	{
		RestTemplate rt = new RestTemplate();
		customer = rt.postForObject("http://localhost:8012/customers/" + id, customer, Customer.class);
		return customer;
	}
	
}
