package edu.northeastern.cs5200.jpas;
import javax.persistence.*;
@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Person {
	
   @Id  
   @GeneratedValue
      (strategy=GenerationType.IDENTITY)
   private int id;
   private String username;
   private String password;
   private String firstName;
   private String lastName;
   
   public Person() {
	   
   }
   public Person(String firstName,String lastName) {
	   this.firstName = firstName;
	   this.lastName = lastName;
   }
   public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public void set(Person newPerson) {
		this.username = newPerson.username != null ?
				newPerson.username : this.username; 
		this.password = newPerson.password != null ?
				newPerson.password : this.password; 
		this.firstName = newPerson.firstName != null ?
				newPerson.firstName : this.firstName; 
		this.lastName = newPerson.lastName != null ?
				newPerson.lastName : this.lastName;
	}
}

