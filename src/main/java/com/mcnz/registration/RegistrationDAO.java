package com.mcnz.registration;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Registration saveRegistration(Registration regis) {
		String sql = "INSERT INTO REGISTRATION (CUSTOMER_ID, EVENT_ID, REGISTRATION_DATE, NOTES) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, regis.getCustomer_id(), regis.getEvent_id(), regis.getRegistration_date(), regis.getNotes());
        return regis;
	}
	
	public Registration saveRegistration(Registration regis, int id) {
		String sql = "INSERT INTO REGISTRATION (ID, CUSTOMER_ID, EVENT_ID, REGISTRATION_DATE, NOTES) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, regis.getCustomer_id(), regis.getEvent_id(), regis.getRegistration_date(), regis.getNotes());
        return regis;
	}
	
	public Collection<Registration> getAllRegistrations() {
		return jdbcTemplate.query("Select * from REGISTRATION", new
				BeanPropertyRowMapper<Registration>(Registration.class));
	}
	
	public Registration getRegistration(int id) {
		String sql = "SELECT * FROM REGISTRATION WHERE id = ?";
		List<Registration> registration = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Registration.class), id);
		return registration.isEmpty() ? null : registration.get(0);
	}
	
	public void deleteRegistration(int id) throws Exception {
		String sql = "DELETE FROM REGISTRATION WHERE id = ?";
		try {
			jdbcTemplate.update(sql, id);
		}catch(DataAccessException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
