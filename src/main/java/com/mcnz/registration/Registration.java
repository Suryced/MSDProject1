package com.mcnz.registration;

public class Registration {
	
	private int id;
	private int customer_id;
	private int event_id;
	private String registration_date;
	private String notes;
	
	public Registration() {}

	public Registration(int id, int customer_id, int event_id, String registration_date, String notes) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.event_id = event_id;
		this.registration_date = registration_date;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
	
	

}
