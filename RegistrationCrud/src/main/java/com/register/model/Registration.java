package com.register.model;

import java.util.Date;

public class Registration {
    private int id;
    private String name;
    private String email;
    private Date dateOfBirth;
    private String phoneNumber;
    private String address;

    // Constructors
    public Registration() {}

    public Registration(int id, String name, String email, Date dateOfBirth, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
    	return "Registration [id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth
    			+ ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }
}
