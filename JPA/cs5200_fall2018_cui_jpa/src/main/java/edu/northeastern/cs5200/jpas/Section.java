package edu.northeastern.cs5200.jpas;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "section")
public class Section extends Course {

	@Id  
	@GeneratedValue
	   (strategy=GenerationType.IDENTITY)
	private int id;	
	private int seat;
	private String title;
	
	@ManyToMany(mappedBy="enrolledSections")
	@JsonIgnore
	private List<Student> enrolledStudents; 
	public void enrollStudent(Student student) {
	   this.enrolledStudents.add(student);
	   if(!student.getEnrolledSections().contains(this)) {
	       student.getEnrolledSections().add(this);
	   }
	}
	
	@ManyToOne()
	@JsonIgnore
	private Course course;
	
	public Section() {
		super();
		enrolledStudents = new ArrayList<Student>();
	}
	
	public Section(String title,int seat, Course course) {
		this.title= title;
		this.seat = seat;
		this.course = course;
		enrolledStudents = new ArrayList<Student>();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public int getSeat() {
		return seat;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
	public void addEnrolledStudents(Student student) {
		this.enrolledStudents.add(student);
	}
}
