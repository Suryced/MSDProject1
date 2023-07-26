package com.mcnz.rps;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return "{\"id\":1,\"event_id\":\"1\",\"customer_id\":\"1\",\"registration_date\":\"2019-01-15T00:00:00.000+0000\",\"notes\":\"please email me the event details\"}";
	}
	
//	@GetMapping("/api/registrations")
//	public void deleteReistratoin() {
//		
//	}
	
//	@CrossOrigin
//	@PostMapping("/registration")
//	public Registration saveRegistration(@RequestBody Registration registration) {
//		registrationDAO.saveRegistration(registration);
//		return registration;
//	}
}
