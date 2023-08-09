package com.cyrus.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationsGateway {

	@Autowired 
	RegistrationsService registrationsService;
	
	@GetMapping("/loaddata")
	public void loadData() {
		registrationsService.loadData();
	}
	
	@GetMapping("/registrations")
	public List<Registration> findAllRegistrations() {
		return registrationsService.findAllRegistrations();
	}
	
	@GetMapping("/registrations/{id}")
	public Optional<Registration> findRegistrationById(@PathVariable("id") String id) {
		return registrationsService.findRegistrationById(id);
	}
	
	@DeleteMapping("/registrations/{id}")
	public void deleteRegistrationById(@PathVariable("id") String id) {
		registrationsService.deleteRegistrationById(id);
	}
	
	@PostMapping("/registrations")
	public Registration create(@RequestBody Registration Registration)
	{
		return registrationsService.saveOrUpdate(Registration);
	}
	
	@PutMapping("/registrations/{id}")
	public Registration update(@RequestBody Registration Registration)
	{
		System.out.println("You are in the put method");
		return create(Registration);
	}
	
	
}
