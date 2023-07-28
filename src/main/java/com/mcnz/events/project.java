package com.mcnz.events;

public class project {
	public long id;
	public String eventCode, title, description;

	
	public project () {
		
	}

	public project(long id, String eventCode, String title, String description) {
		super();
		this.id = id;
		this.eventCode = eventCode;
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}


}
