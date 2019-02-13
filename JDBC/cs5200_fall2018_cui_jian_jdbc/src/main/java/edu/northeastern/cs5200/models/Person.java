package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private Date dob;
	private List<Phone> phone;
	private List<Address> address;
	
	
	public Person(int id, String firstName, String lastName,
			String username, String password, 
			String email, Date dob) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phone = new ArrayList<Phone>();
		this.address = new ArrayList<Address>();
	}
	
	public Person(int id, String firstName, String lastName,
			String username, String password, 
			String email, Date dob,
			Phone phone,Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.phone = new ArrayList<Phone>();
		this.address = new ArrayList<Address>();
		this.phone.add(phone);
		this.address.add(address);
	}
	
	public Person() {
		this.phone = new ArrayList<Phone>();
		this.address = new ArrayList<Address>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id  = id;
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void addPhone(Phone phone) {
	this.phone.add(phone);
	}
	
	public void removePhone(Phone phone) {
	this.phone.remove(phone);
	}
	
	public void addAddress(Address address) {
	this.address.add(address);
	}
	
	public void removeAddress(Address address) {
	this.address.remove(address);
	}

	public List<Phone> getPhone(){
		return phone;
	}
	
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	
	public List<Address> getAddress(){
		return address;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
