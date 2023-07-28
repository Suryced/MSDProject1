package com.mcnz.events;

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
public class Api {
	
//	@Autowired
//	private ProjectDAO projectDAO;
	
	@CrossOrigin
	@GetMapping("/api/events")
	// might have to change to collection instead of arraylist
	public ArrayList<project> getEvents() {
//	public String getEvents() {
//		return projectDAO.getAllEvents();
		ArrayList<project> list = new ArrayList<>();
		project p1 = new project(1,"ABC123", "All-Java Class", "example description");
		project p2 = new project(2,"ABC124", "All-Python Class", "example description");
		project p3 = new project(3,"ABC125", "All-SQL Class", "example description");
		project p4 = new project(4,"ABC126", "All-JavaScript Class", "example description");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/api/events/{eventId}")
	public project getEvents(@PathVariable("eventId") int id) {
//	public String getEvent(@PathVariable String id) {
//		return projectDAO.getAllEvents();
		return getEvents().get(id);
	}
	
	@CrossOrigin
	@PostMapping("/api/events")
	public ResponseEntity<?> addEvent(@RequestBody project newEvent, UriComponentsBuilder uri) {
		if (newEvent.getId() != 0 || newEvent.getEventCode() != null) {
			return ResponseEntity.badRequest().build();
		}
//		newEvent = repo.save(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;

	}
	
	@PutMapping("/api/events/{eventId}")
	public ResponseEntity<?> putCustomer(@RequestBody project newEvent, @PathVariable("eventId") int eventId){
		if (newEvent.getId() != eventId || newEvent.getEventCode() == null) {
			return ResponseEntity.badRequest().build();
		}
//		newEvent = repo.save(newEvent);
		return ResponseEntity.ok().build();
	}
	
	
	// will need to change this so that it deletes from the repo
	// will also need to turn the return value into a ResponseEntity<?>
	@DeleteMapping("/api/events/{eventId}")
	public int deleteReistratoin(@PathVariable("eventId") int eventId) {
//		repo.delete(eventId)
		return eventId;
	}
	

}
