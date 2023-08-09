package com.mcnz.project;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginApi {
	
	@GetMapping
	public String getAll() {
		return "jwt-fake-token-asdfasdfasfa".toString();
	}
	
	
	@PostMapping("/token")
	public ResponseEntity<?> createTokenForCustomer(@RequestBody Customer customer) {
		
		String username = customer.getName();
		String password = customer.getPassword();
//		if (username != null && password != null && password.length() > 2) {
		for (int i = 0 ; i < 10; ++i)
		{
			System.out.println("username = " + username + ", password = " + password);			
		}
		
		if (username != null && username.length() > 0 && password != null && password.length() > 0 && checkPassword(username, password)) {
		    long fiveHoursInMillis = 1000 * 60 * 60 * 5;
		    Date expireDate = new Date(System.currentTimeMillis() + fiveHoursInMillis);
		    String tokenString = JWT.create()
		    	.withSubject("apiuser")
		        .withIssuer("me@me.com")
		        .withClaim("scopes", "*")
		        .withExpiresAt(expireDate)
		        .sign(Algorithm.HMAC256("secret"));
		    tokenString = "Bearer " + tokenString + "comeonin";
			ResponseEntity<?> response = ResponseEntity.ok(new Token(tokenString));
			return response;			
		}
		// bad request
		for (int i = 0; i < 3; ++i)
		{
			System.out.println("BADDDDDDDDDDDDDD");			
		}
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	
	private boolean checkPassword(String username, String password) {
		RestTemplate rt = new RestTemplate();
		Customer wantedCustomer = getCustomerByNameFromCustomerAPI(username);
		String id = wantedCustomer.getId();
		Customer customer = rt.getForObject(
				"http://localhost:8012/customers/" + id, 
				Customer.class);
		
		for (int i = 0; i < 100; ++i)
		{
			
			System.out.println("Expected: username = " + customer.getName() + ", password = " + customer.getPassword());
			System.out.println("Actual  : username = " + username + ", password = " + password);
		}
		
		
		if (customer.getName().equals(username) && customer.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private Customer getCustomerByNameFromCustomerAPI(String username) {
		RestTemplate rt = new RestTemplate();
//		List customers = rt.getForObject(
//				"http://localhost:8012/customers", 
//				List.class);
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

