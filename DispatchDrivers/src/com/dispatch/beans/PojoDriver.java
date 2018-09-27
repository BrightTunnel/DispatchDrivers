package com.dispatch.beans;

import java.io.Serializable;
import java.util.Date;

public class PojoDriver implements Serializable {
	private Long DriverID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;
	private String Address;
	private Integer Urgency;
	private Integer IsAdmin;
	private Date DateCreated;

	public PojoDriver() {
	}

	public Long getDriverID() {
		return DriverID;
	}

	public void setDriverID(Long driverID) {
		DriverID = driverID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Integer getUrgency() {
		return Urgency;
	}

	public void setUrgency(Integer urgency) {
		Urgency = urgency;
	}

	public Integer getIsAdmin() {
		return IsAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		IsAdmin = isAdmin;
	}

	public Date getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}

}
