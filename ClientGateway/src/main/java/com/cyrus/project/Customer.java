package com.cyrus.project;

public class Customer {


	private String mongoId;
	
	private Long id;
	public Long getId() {
		try {
			return (new Long (mongoId.replaceAll("[^0-9]", "").substring(0, 7)));
		} catch (Exception e) {
			return null;
		}
	}
	
	public void setId(Long id) {
		if (id == null) {
			mongoId = null;
		} 
		this.id = id;
	}

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}
	
	private String name, email, password;
	
	public Customer() {}
	
	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}


	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
