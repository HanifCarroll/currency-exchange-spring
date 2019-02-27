package com.exchange.controllers.to;

public class AccountTO {
	
	private long id;
	private String firstName;
	private String lastName;
	private String contactEmail;
	private String payPalEmail;
	private String dateOFBirth;
	private String countryOfResidence;
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
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getPayPalEmail() {
		return payPalEmail;
	}
	public void setPayPalEmail(String payPalEmail) {
		this.payPalEmail = payPalEmail;
	}
	public String getDateOFBirth() {
		return dateOFBirth;
	}
	public void setDateOFBirth(String dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}
	public String getCountryOfResidence() {
		return countryOfResidence;
	}
	public void setCountryOfResidence(String countryOfResidence) {
		this.countryOfResidence = countryOfResidence;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

}
