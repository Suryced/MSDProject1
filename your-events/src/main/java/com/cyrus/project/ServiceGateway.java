package com.cyrus.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class ServiceGateway {

	@Autowired
	public EventzService eventzService;
	
	@GetMapping("/loaddata")
	public void loadData() {
		eventzService.loadData();
	}
	
	@GetMapping("/events")
	public List<Event> findAllEvents() {
		return eventzService.findAllEvents();
	}
	
	@GetMapping("/events/{id}")
	public Optional<Event> findEventById(@PathVariable("id") String id) {
		return eventzService.findEventById(id);
	}
	
	@DeleteMapping("/events/{id}")
	public void deleteEventById(@PathVariable("id") String id) {
		List<Event> cus = findAllEvents();
		for(Event e : cus) {
			System.out.println(e.getMongoId() + ":  " + id);
			if(("" + e.getId()).equals(id)) {	
				eventzService.deleteEventById(e.getMongoId());
			}
		}
	}
	
	@PostMapping("/events")
	public Event create(@RequestBody Event event)
	{
		return eventzService.saveOrUpdate(event);
	}
	
	@PutMapping("/events/{id{")
	public Event update(@RequestBody Event event)
	{
		return create(event);
	}
	
}
