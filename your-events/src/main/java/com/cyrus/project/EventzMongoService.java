package com.cyrus.project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


@Service
public class EventzMongoService implements EventzService {

	@Autowired
	EventzMongoRepository mongoRepository;

	@Override
	public void loadData() {
		Event event1 = new Event("abc", "cars and coffee", "Fun Event");
		Event event2 = new Event("def", "exotics and coffee", "Single Dads Only");
		Event event3 = new Event("def", "exotics and coffee", "Single Dads Only");
		mongoRepository.save(event1);
		mongoRepository.save(event2);
		mongoRepository.save(event3);
		
	
	}
	
	@Override
	public List<Event> findAllEvents() {
		return mongoRepository.findAll();
	}
	
	@Override
	public Optional<Event> findEventById(String id) {
		return mongoRepository.findById(id);
	}
	
	@Override
	public void deleteEventById(String id) {
		mongoRepository.deleteById(id);
	}
	
	@Override
	public void deleteEvent(Event event)
	{
		mongoRepository.delete(event);
	}
	
	@Override
	public Event saveOrUpdate(Event event)
	{
		return mongoRepository.save(event);
	}
	
}
