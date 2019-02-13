package edu.northeastern.cs5200.models;
import java.sql.Date;
public class Developer extends Person{

	private String developerKey;
	private int developerId;
	
	public Developer() {
		super();
	}
	
	public Developer(int id, String firstName, 
			String lastName,String developerKey) {
		super(id,firstName, lastName, firstName, firstName+lastName, 
				firstName+"@gmail.com", new java.sql.Date(System.currentTimeMillis()));
		this.developerKey = developerKey;
		this.developerId = id;
	}

	public Developer(int id, String firstName, 
			String lastName, String username,
			String password, String email,
			Date dob, String developerKey) {
		super(id,firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
		this.developerId = id;
	}

	public Developer(int id, String firstName, 
			String lastName, String username,
			String password, String email,
			Date dob, String developerKey,
			Phone phone, Address address) {
		super(id,firstName, lastName, username, password, email, dob,phone,address);
		this.developerKey = developerKey;
		this.developerId = id;
	}

	public int getDeveloperId() {
		return developerId;
	}
	
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	
	public String getDeveloperKey() {
		return developerKey;
	}
	
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	
	
}
