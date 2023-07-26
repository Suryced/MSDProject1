package Events;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public  Collection<project> getAllProjects() {
		// Replace this statement with the call to jdbcTemplate.
		
		return jdbcTemplate.query("Select * from EVENTS", new
				BeanPropertyRowMapper<project>(project.class));
	}
}