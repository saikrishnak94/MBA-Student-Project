package com.mba.form;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class Contact {
	@NotNull
	@NotEmpty(message ="User id should not be empty")
	private String userId;
	@NotNull
	@NotEmpty(message ="password should not be empty")
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
