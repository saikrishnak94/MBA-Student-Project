package com.mba.form;

import org.hibernate.validator.constraints.NotEmpty;

public class AdvisorForm {
	@NotEmpty(message="Degree code should not empty")
	String id;
	@NotEmpty(message="Concentration should not empty")
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
