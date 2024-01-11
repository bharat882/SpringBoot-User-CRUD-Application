package com.example.demo.ui.model.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserRest {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String userId;

//	public UserRest() {
//		setFirstName(firstName);
//		setLastName(lastName);
//		setEmail(email);
//		setUserid(userId);
//	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void setPassword(String userid) {
		this.password = password;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}

}
