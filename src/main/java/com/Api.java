package Events;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin
@RestController
public class Api {

//	@Autowired
//	private ProjectDao projectDAO;
//	
//	@CrossOrigin
//	@GetMapping("/api/events")
//	public Collection<project> getAllProjects() {
//		return projectDAO.getAllProjects();
//	}
	
	@CrossOrigin
	@GetMapping("/api/events")
	public String getEvents() {
		return "{\"id\":1,\"code\":\"1\",\"title\":\"All-Java Conference\",\"description\":\"Lectures and exhibits covering all Java topics\"}";
	}
	
	
}
