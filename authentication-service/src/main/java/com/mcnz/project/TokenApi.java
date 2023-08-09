package com.mcnz.project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class TokenApi {

	JWTUtil jwtUtil = new JWTHelper();
	
	@PostMapping("/token")
	public ResponseEntity<?> getToken(@RequestBody Customer customer) {
		
		String username = customer.getName();
		String password = customer.getPassword();
		//String scopes = tokenRequestData.getScopes();
		
		if (username != null && username.length() > 0 
				&& password != null && password.length() > 0 
				&& Authenticator.checkPassword(username, password)) {
			Token token = jwtUtil.createToken("*");
			ResponseEntity<?> response = ResponseEntity.ok(token);
			return response;			
		}
		// bad request
		return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	
}
