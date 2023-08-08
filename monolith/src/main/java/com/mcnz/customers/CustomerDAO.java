package com.mcnz.customers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Collection<Customer> getAllCustomers() 
	{
		return jdbcTemplate.query("Select * from CUSTOMERS", new BeanPropertyRowMapper<Customer>(Customer.class));
	}
	
	public Customer saveCustomer(Customer customer)
	{
		String sql = "INSERT INTO CUSTOMERS (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getPassword());
		return customer;
	}
	
	public Customer updateCustomer(Customer customer)
	{
		String sql = "UPDATE CUSTOMERS SET NAME=?, EMAIL=?, PASSWORD=? WHERE ID=?";
		jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getPassword());
		return customer;
	}
	
	public Customer getCustomer(int id)
	{
		String sql = "SELECT * FROM CUSTOMERS WHERE id=?";
		List<Customer> customer = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class), id);
		return customer.isEmpty() ? null : customer.get(0);
	}
	
	public void deleteCustomer(int id) {
		String sql = "DELETE FROM CUSOTMERS WHERE ID=?";
		try {
			jdbcTemplate.update(sql, id);
	
		} catch (DataAccessException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
