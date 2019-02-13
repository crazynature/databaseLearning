package edu.northeastern.cs5200.jpas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String feedback;
	private int grade;
	
	@ManyToMany()
	@JoinTable(name="EnrollmentToStudent",
	joinColumns=@JoinColumn(name="Enrollment_ID", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="Student_ID", referencedColumnName="id"))
	@JsonIgnore
	private List<Student> students;
	
	@ManyToMany()
	@JoinTable(name="EnrollmentToSection",
	joinColumns=@JoinColumn(name="Enrollment_ID", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="Section_ID", referencedColumnName="id"))
	@JsonIgnore
	private List<Section> sections;
	
	public Enrollment() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	

}