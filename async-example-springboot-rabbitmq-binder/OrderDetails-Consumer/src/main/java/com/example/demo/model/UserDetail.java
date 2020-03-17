package com.example.demo.model;


public class UserDetail {
	
	int id;
	String address;
	String firstName;
	String lastName ;
	String middleName;
	
	public UserDetail(int id, String address, String firstName, String lastName, String middleName) {
		super();
		this.id = id;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", address=" + address + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + "]";
	}
}
