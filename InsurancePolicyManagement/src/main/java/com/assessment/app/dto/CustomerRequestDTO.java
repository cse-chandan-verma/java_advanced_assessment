package com.assessment.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CustomerRequestDTO {
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@Email(message = "Email format is incorrect")
	@NotBlank(message = "Email cannot be blank")
	private String email;
	
	@NotNull(message = "Phone Number field cannot be blank")
	@Positive(message = "Phone Number cannot be negative")
	private Long phoneNumber;
	
	@NotBlank(message = "Address cannot be negative")
	private String address;
	
	public CustomerRequestDTO() {
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
