package com.cyrus.project;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
}
