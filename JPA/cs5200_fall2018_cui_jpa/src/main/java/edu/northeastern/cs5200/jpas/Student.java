package edu.northeastern.cs5200.jpas;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "student")
public class Student extends Person {
	@Id  
	@GeneratedValue
	    (strategy=GenerationType.IDENTITY)
	private int id;
	private int gradYear;
	private long scholarship;
	
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name="ENROLLMENT",
	   joinColumns=@JoinColumn(name="STUDENT_ID",
	   referencedColumnName="ID"),
	   inverseJoinColumns=@JoinColumn(name=
	      "SECTION_ID", referencedColumnName="ID"))
	private List<Section> enrolledSections;
	
	
	public Student() {
		super();
		enrolledSections = new ArrayList<Section>();
	}

	public Student(String firstName, String lastName, int gradYear, long scholarship) {
		super(firstName,lastName);
		this.gradYear= gradYear;
		this.scholarship=scholarship;
		enrolledSections = new ArrayList<Section>();
	}
	public int getId() {
			return id;
	}
	public void setId(int id) {
			this.id = id;
	}
	
	public List<Section> getEnrolledSections(){
		return this.enrolledSections;
	}
	
	public void addSection(Section section) {
		this.enrolledSections.add(section);
	}
	
	public void setSection(List<Section> sections) {
		this.enrolledSections = sections;
	}
	
	public long getscholarship() {
		return scholarship;
	}

	public void setscholarship(long scholarship) {
		this.scholarship = scholarship;
	}
	
	public int getgradYear() {
		return gradYear;
	}

	public void setgradYear(int gradYear) {
		this.gradYear = gradYear;
	}

	public List<Section> getEnrollments() {
		return enrolledSections;
	}

	public void setEnrollmentsActed(List<Section> enrolledSections) {
		this.enrolledSections = enrolledSections;
	}
	
	public void enrollSection(Section section) {
		   this.enrolledSections.add(section);
		   if(!section.getEnrolledStudents().contains(this))
		       section.getEnrolledStudents().add(this);
		}

	public void set(Student newStudent) {
		this.gradYear = newStudent.gradYear != 0 ?
				newStudent.gradYear : this.gradYear; 
		this.enrolledSections = newStudent.enrolledSections != null ?
				newStudent.enrolledSections : this.enrolledSections; 
	}
 
}