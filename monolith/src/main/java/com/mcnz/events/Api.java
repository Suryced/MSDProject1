package com.mcnz.events;

import java.net.URI;
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
public class Api {
	
	@Autowired
	private ProjectDao ProjectDao;

	@CrossOrigin
	@GetMapping("/api/events")
	public Collection<project> getEvents() {
		/// gets all of the registrations in the database
		return ProjectDao.getAllEvents();
	}
	
	@CrossOrigin
	@GetMapping("/api/events/{eventId}")
	public project getEvent(@PathVariable("eventId") int id) {
		/// Gets a specific registration using the ID given in the URL
		return ProjectDao.getEvent(id);
	}
	
	@CrossOrigin
	@PostMapping("/api/events")
	public ResponseEntity<?> addEvent(@RequestBody project newEvent, UriComponentsBuilder uri) {
		/// Saves a registration to the database
		if (newEvent.getId() != 0 || newEvent.getCode() == null) {
			return ResponseEntity.badRequest().build();
		}
		newEvent = ProjectDao.saveEvent(newEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEvent.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;

	}
	
	@PutMapping("/api/events/{eventId}")
	public ResponseEntity<?> updateRegistration(@RequestBody project newEvent, @PathVariable("eventId") int eventId){
		/// Saves a registration to the database to a specific id
		newEvent = ProjectDao.updateEvent(newEvent, eventId);
		return ResponseEntity.ok().build();
	}
	
	
	@DeleteMapping("/api/events/{eventId}")
	public ResponseEntity<?> deleteEvent(@PathVariable("eventId") int eventId) {
		try {
			ProjectDao.deleteEvent(eventId);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

}
