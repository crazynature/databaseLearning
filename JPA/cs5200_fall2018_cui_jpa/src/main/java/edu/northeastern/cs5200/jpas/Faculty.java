package edu.northeastern.cs5200.jpas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "faculty")
public class Faculty extends Person{

	   @Id  
	   @GeneratedValue
	      (strategy=GenerationType.IDENTITY)
	   private int id;
	   private String office;
	   private boolean tenured;
	   
	   @OneToMany(mappedBy = "faculty")
	   @JsonIgnore
	   private List<Course> courses;
	   public Faculty() {
			super();
			courses = new ArrayList<Course>();
		}
	   
	   public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
	   public Faculty(String firstName, String lastName,String office,boolean tenured) {
			super(firstName,lastName);
			this.office=office;
			this.tenured=tenured;
			courses = new ArrayList<Course>();
		}

		public String getOffice() {
			return office;
		}

		public void setOffice(String office) {
			this.office = office;
		}
		
		public boolean getTenured() {
			return tenured;
		}

		public void setTenured(boolean tenured) {
			this.tenured = tenured;
		}	
		
		public void setCourse(List<Course> courses) {
			this.courses=courses;
		}
		
		public List<Course> getCourses(){
			return this.courses;
		}
		public void addCourse(Course course) {
			this.courses.add(course);
		}
}
