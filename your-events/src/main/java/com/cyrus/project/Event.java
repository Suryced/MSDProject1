package com.cyrus.project;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="events")
public class Event {
	
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
	}

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}

	
	private String code, title, description;

	public Event() 
	{
	}
	
	public Event(String code, String title, String description) {
		super();
		this.code = code;
		this.title = title;
		this.description = description;
	}
	

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
//	@Override
//	public String toString() {
//		return "Event [id=" + id + ", title=" + title + ", description=" + description + "]";
//	}

	
	
}
