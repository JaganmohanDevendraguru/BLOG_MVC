package com.example.blog_mvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7704401093421140398L;
	
	private int userId;
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;
	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;
	@Size(min = 6, max = 18, message = "Password should be between 6 and 18")
	private String password;
	@Size(min = 6, max = 18, message = "User name should be between 6 and 18")
	private String userName;
	@Email(message = "Please enter valid email")
	private String email;
	private String mobile;
	private String authToken;
	private String street;
	private String apt;
	private String city;
	private String state;
	private int zip;
	private String country;
	private String activeFlag;
	private Date registerDate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String firstName, String lastName, String password, String userName, String email,
			String mobile, String authToken, String street, String apt, String city, String state, int zip,
			String country, String activeFlag, Date registerDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
		this.authToken = authToken;
		this.street = street;
		this.apt = apt;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.activeFlag = activeFlag;
		this.registerDate = registerDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", userName=" + userName + ", email=" + email + ", mobile=" + mobile + ", authToken="
				+ authToken + ", street=" + street + ", apt=" + apt + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + ", activeFlag=" + activeFlag + ", registerDate=" + registerDate + "]";
	}
	
}
