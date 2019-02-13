package edu.northeastern.cs5200.models;
import java.sql.Date;
public class User extends Person{

	private boolean userAgreement;
	private int userId;
	public User() {
		super();
	}
	
	public User(int id, String firstName, 
			String lastName) {
		super(id,firstName, lastName, firstName.toLowerCase(), firstName.toLowerCase(), 
				firstName.toLowerCase()+"@"+lastName.toLowerCase(), new java.sql.Date(System.currentTimeMillis()));
		this.userAgreement = false;
		this.userId = id;
	}
	
	public User(int id, String firstName, String lastName, 
			String username, String password, 
			String email, Date dob, boolean userAgreement) {
		super(id, firstName, lastName, username, password, email, dob);
		this.userAgreement = userAgreement;
	}
	
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public boolean getUserAgreement() {
		return userAgreement;
	}
	
	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	
	

}
