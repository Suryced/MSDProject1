package com.cyrus.project;

import org.springframework.data.annotation.Id;

public class Registration {

	@Id
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
		id = id;
	}

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}

	public String getEvent_id() {
		return event_id;
	}
	
	
	
	private String event_id, customer_id, notes;
	private java.util.Date registration_date = new java.util.Date();
	
	public Registration() {}

	public Registration(String event_id, String customer_id, String notes) {
		super();
		this.event_id = event_id;
		this.customer_id = customer_id;
		this.notes = notes;
	}



	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public java.util.Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(java.util.Date registration_date) {
		this.registration_date = registration_date;
	}
	
	
	
}
