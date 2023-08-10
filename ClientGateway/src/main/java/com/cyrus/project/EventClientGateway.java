package com.cyrus.project;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@CrossOrigin
@RestController
public class EventClientGateway {
	
	@GetMapping("/api/events")
	public List<Event> getAll() {
		RestTemplate rt = new RestTemplate();
		List events = rt.getForObject(
				"http://localhost:8011/events", 
				List.class);
		System.out.println(events);
		return events;
		
	}
	
	@GetMapping("/api/events/{id}")
	public Event getById(@PathVariable String id) {
		RestTemplate rt = new RestTemplate();
		Event event = rt.getForObject(
				"http://localhost:8011/events/" + id, 
				Event.class);
		System.out.println(event);
		return event;
	}
	
	@DeleteMapping("/api/events/{id}")
	public void deleteById(@PathVariable String id)
	{
		RestTemplate rt = new RestTemplate();
		rt.delete("http://localhost:8011/events/" + id);
	}
	
	@PostMapping("/api/events")
	public Event create(@RequestBody Event event)
	{
		RestTemplate rt = new RestTemplate();
		event = rt.postForObject("http://localhost:8011/events/", event, Event.class);
		return event;
	}
	
	@PutMapping("/api/events/{id}")
	public Event update(@RequestBody Event event, @PathVariable String id)
	{
		RestTemplate rt = new RestTemplate();
		if (id != null && id.length() < 5) {
			event.setMongoId(null);
		}
		event = rt.postForObject("http://localhost:8011/events/", event, Event.class);
		return event;
	}

}
