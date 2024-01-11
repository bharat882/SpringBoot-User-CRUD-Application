package com.example.demo.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {
	
	@NotNull(message="First Name cannot be null")
	private String firstName;
	@NotNull(message="Last Name cannot be null")
	private String lastName;
	@Email(message="Email is invalid") @NotNull(message="Email cannot be null")
	private String email;
	@NotNull(message="Password cannot be null") @Size(min=8, max=16, message = "Password should be equal to or greater than 8 characters")
	private String password;

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

	public void setPassword(String password) {
		this.password = password;
	}

}
