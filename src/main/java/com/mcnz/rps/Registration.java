package com.mcnz.rps;

public class Registration {
	
	private String customer;
	private String event;
	private String date;
	
	public Registration() {}

	public Registration(String customer, String event, String date) {
		super();
		this.customer = customer;
		this.event = event;
		this.date = date;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
