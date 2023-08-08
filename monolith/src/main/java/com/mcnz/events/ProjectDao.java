package com.mcnz.events;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public project saveEvent(project events) {
		String sql = "INSERT INTO EVENTS (CODE, TITLE, DESCRIPTION) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, events.getCode(), events.getTitle(), events.getDescription());
        return events;
	}
	
	public project updateEvent(project events, int event_id) {
		String sql = "UPDATE EVENTS SET CODE=?, TITLE=?, DESCRIPTION=? WHERE ID = ?";

        jdbcTemplate.update(sql, events.getCode(), events.getTitle(), events.getDescription(), event_id);
        return events;
        
	}
	
	public Collection<project> getAllEvents() {
		return jdbcTemplate.query("Select * from EVENTS", new
				BeanPropertyRowMapper<project>(project.class));
	}
	
	public project getEvent(int id) {
		String sql = "SELECT * FROM EVENTS WHERE id = ?";
		List<project> events = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(project.class), id);
		return events.isEmpty() ? null : events.get(0);
	}
	
	public void deleteEvent(int id) throws Exception {
		String sql = "DELETE FROM EVENTS WHERE id = ?";
		try {
			jdbcTemplate.update(sql, id);
		}catch(DataAccessException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
