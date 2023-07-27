package com.mcnz.registration;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RegistrationAPI {
	
//	@Autowired
//	private RegistrationDAO registrationDAO;

	@CrossOrigin
	@GetMapping("/api/registrations")
//	public Collection<Registration> getRegistrations() {
	public String getRegistrations() {
//		return registrationDAO.getAllRegistrations();
		return "{\"id\":1,\"event_id\":\"1\",\"customer_id\":\"1\",\"registration_date\":\"2019-01-15T00:00:00.000+0000\",\"notes\":\"please email me the event details\"},{\"id\":2,\"event_id\":\"1\",\"customer_id\":\"2\",\"registration_date\":\"2019-01-17T00:00:00.000+0000\",\"notes\":\"looking for info on local hotels\"}";
	}
	
	@CrossOrigin
	@GetMapping("/api/registrations/{id}")
//	public Collection<Registration> getRegistrations() {
	public String getRegistration(@PathVariable String id) {
//		return registrationDAO.getAllRegistrations();
		return "{\"id\":1,\"event_id\":\"1\",\"customer_id\":\"1\",\"registration_date\":\"2019-01-15T00:00:00.000+0000\",\"notes\":\"please email me the event details\"}";
	}
	
//	@CrossOrigin
//	@PostMapping("/registration/")
//	public Registration saveRegistration(@RequestBody Registration registration) {
//		registrationDAO.saveRegistration(registration);
//		return registration;
//	}
	
	
	
	@PutMapping("/api/registrations/{id}")
	public String deleteReistratoin(@PathVariable String id) {
		return id;
	}
	

}
