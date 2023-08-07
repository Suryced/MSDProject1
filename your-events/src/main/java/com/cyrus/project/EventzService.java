package com.cyrus.project;

import java.util.List;
import java.util.Optional;

public interface EventzService {

	void loadData();

	List<Event> findAllEvents();

	Optional<Event> findEventById(String id);

	void deleteEventById(String id);

	void deleteEvent(Event event);

	Event saveOrUpdate(Event event);

}