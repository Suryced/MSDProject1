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
public class RegistrationClientGateway {
	@GetMapping("/api/registrations")
	public List<Registration> getAll() {
		RestTemplate rt = new RestTemplate();
		List registrations = rt.getForObject(
				"http://localhost:8013/registrations", 
				List.class);
		System.out.println(registrations);
		return registrations;
		
	}
	
	@GetMapping("/api/registrations/{id}")
	public Registration getById(@PathVariable String id) {
		RestTemplate rt = new RestTemplate();
		Registration registration = rt.getForObject(
				"http://localhost:8013/registrations/" + id, 
				Registration.class);
		System.out.println(registration);
		return registration;
	}
	
	@DeleteMapping("/api/registrations/{id}")
	public void deleteById(@PathVariable String id)
	{
		RestTemplate rt = new RestTemplate();
		rt.delete("http://localhost:8013/registrations/" + id);
	}
	
	@PostMapping("/api/registrations")
	public Registration create(@RequestBody Registration registration)
	{
		RestTemplate rt = new RestTemplate();
		registration = rt.postForObject("http://localhost:8013/registrations/", registration, Registration.class);
		return registration;
	}
	
	@PutMapping("/api/registrations/{id}")
	public Registration update(@RequestBody Registration registration, @PathVariable String id)
	{
		RestTemplate rt = new RestTemplate();
		if (id != null && id.length() < 5) {
			registration.setId(null);
		}
		registration = rt.postForObject("http://localhost:8013/registrations/", registration, Registration.class);
		return registration;
	}

}
