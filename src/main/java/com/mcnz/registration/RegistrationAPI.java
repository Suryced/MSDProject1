package com.mcnz.registration;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
public class RegistrationAPI {
	
	@Autowired
	private RegistrationDAO registrationDAO;

	@CrossOrigin
	@GetMapping("/api/registrations")
	public Collection<Registration> getRegistrations() {
		/// gets all of the registrations in the database
		return registrationDAO.getAllRegistrations();
	}
	
	@CrossOrigin
	@GetMapping("/api/registrations/{registrationId}")
	public Registration getRegistrations(@PathVariable("registrationId") int id) {
		/// Gets a specific registration using the ID given in the URL
		return registrationDAO.getRegistration(id);
	}
	
	@CrossOrigin
	@PostMapping("/api/registrations")
	public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		/// Saves a registration to the database
		if (newRegistration.getId() != 0 || newRegistration.getRegistration_date() == null) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = registrationDAO.saveRegistration(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;

	}
	
	@PutMapping("/api/registrations/{registrationId}")
	public ResponseEntity<?> updateRegistration(@RequestBody Registration newRegistration, @PathVariable("registrationId") int registrationId){
		try {
			Registration r = registrationDAO.getRegistration(registrationId);
			if (r != null) {
				registrationDAO.updateRegistration(newRegistration, registrationId);
			}else{
				registrationDAO.saveRegistration(newRegistration);
			}
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			registrationDAO.saveRegistration(newRegistration);
			return ResponseEntity.ok().build();
		}

	}
	
	
	@DeleteMapping("/api/registrations/{registrationId}")
	public ResponseEntity<?> deleteRegistration(@PathVariable("registrationId") int registrationId) {
		try {
			registrationDAO.deleteRegistration(registrationId);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

}
