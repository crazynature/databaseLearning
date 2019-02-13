package edu.northeastern.cs5200.jpas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String label;
	@ManyToOne()
	@JsonIgnore
	private Faculty faculty;
	
	@OneToMany(mappedBy = "course")
	@JsonIgnore
	private List<Section> sections;
	
	public Course() {
		sections = new ArrayList<Section>();	
	}
	
	public Course(String label, Faculty faculty){
		this.label=label;
		this.faculty = faculty;
		sections = new ArrayList<Section>();
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty=faculty;
	}
	
	public Faculty getFaculty() {
		return this.faculty;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void addSection(Section section) {
		this.sections.add(section);
	}
	
	public void setSection(List<Section> sections) {
		this.sections= sections;
	}
	
	public List<Section> getSections(){
		return sections;
	}
	
	public void set(Course newCourse) {
		this.label = newCourse.label != null ?
				newCourse.label : this.label; 
		this.sections = newCourse.sections != null ?
				newCourse.sections : this.sections; 
	}
}
