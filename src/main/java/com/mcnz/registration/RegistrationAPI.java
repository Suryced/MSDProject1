package com.mcnz.registration;

import java.net.URI;
import java.util.ArrayList;

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
	
//	@Autowired
//	private RegistrationDAO registrationDAO;

	@CrossOrigin
	@GetMapping("/api/registrations")
	// might have to change to collection instead of arraylist
	public ArrayList<Registration> getRegistrations() {
//	public String getRegistrations() {
//		return registrationDAO.getAllRegistrations();
		ArrayList<Registration> list = new ArrayList<>();
		Registration r1 = new Registration(1, 1, 1, "today", "send me an email");
		Registration r2 = new Registration(2, 8, 2, "today", "send me an email");
		Registration r3 = new Registration(3, 3, 6, "today", "send me an email");
		Registration r4 = new Registration(4, 4, 4, "today", "send me an email");
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/api/registrations/{registrationId}")
	public Registration getRegistrations(@PathVariable("registrationId") int id) {
//	public String getRegistration(@PathVariable String id) {
//		return registrationDAO.getAllRegistrations();
		return getRegistrations().get(id);
	}
	
	@CrossOrigin
	@PostMapping("/api/registrations")
	public ResponseEntity<?> addRegistration(@RequestBody Registration newRegistration, UriComponentsBuilder uri) {
		if (newRegistration.getId() != 0 || newRegistration.getRegistration_date() == null) {
			return ResponseEntity.badRequest().build();
		}
//		newRegistration = repo.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;

	}
	
	@PutMapping("/api/registrations/{registrationId}")
	public ResponseEntity<?> putCustomer(@RequestBody Registration newRegistration, @PathVariable("registrationId") int registrationId){
		if (newRegistration.getId() != registrationId || newRegistration.getRegistration_date() == null) {
			return ResponseEntity.badRequest().build();
		}
//		newRegistration = repo.save(newRegistration);
		return ResponseEntity.ok().build();
	}
	
	
	// will need to change this so that it delets from the repog
	// will also need to turn the return value into a ResponseEntity<?>
	@DeleteMapping("/api/registrations/{registrationId}")
	public int deleteReistratoin(@PathVariable("registrationId") int registrationId) {
//		repo.delete(registrationId)
		return registrationId;
	}
	

}
