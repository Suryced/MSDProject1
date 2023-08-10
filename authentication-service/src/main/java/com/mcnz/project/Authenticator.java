package com.mcnz.project;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Authenticator {
	
	public static boolean checkUser(String username) {
		Optional<Customer> c = getCustomerByNameFromCustomerAPI(username);
		
		if(c != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkPassword(String username, String password) {
		Optional<Customer> c = getCustomerByNameFromCustomerAPI(username);
		
		if (c != null) {
			Customer customer = c.get(); // turns the optional customer into a real customer
			if (customer.getPassword() == password) {
				return true;
			}
		}
		return false;
		
	}
	
	private static Optional<Customer> getCustomerByNameFromCustomerAPI(String username) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Customer[]> response = rt.getForEntity("http://localhost:8012/customers", Customer[].class);
		Customer[] customers = response.getBody();
		for (Customer c : customers)
		{
			if (c.getName().equals(username))
			{
				Optional<Customer> ret_customer = Optional.of(c);
				return ret_customer;
			}
		}
		return null;
	}  
	
}
