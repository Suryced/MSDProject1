package com.mcnz.project;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Authenticator {
	
	// useless for now 
	public static boolean checkUser(String username) {
		Customer c = getCustomerByNameFromCustomerAPI(username);
		
		if(c.getName() != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean checkPassword(String username, String password) {
		Customer c = getCustomerByNameFromCustomerAPI(username);
		
		if (c.getName() == null || c.getPassword() == null) {
			return false;
		}
		
		if (c.getName().equals(username)) {
			if (c.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
		
	}
	
	private static Customer getCustomerByNameFromCustomerAPI(String username) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Customer[]> response = rt.getForEntity("http://localhost:8012/customers", Customer[].class);
		Customer[] customers = response.getBody();
		for (Customer c : customers)
		{
			if (c.getName().equals(username))
			{
				return c;
			}
		}
		return new Customer();
	}  
	
}
