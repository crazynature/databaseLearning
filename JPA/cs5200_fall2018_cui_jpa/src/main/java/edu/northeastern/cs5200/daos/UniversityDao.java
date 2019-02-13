package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.northeastern.cs5200.jpas.Course;
import edu.northeastern.cs5200.jpas.CourseRepository;
import edu.northeastern.cs5200.jpas.Faculty;
import edu.northeastern.cs5200.jpas.FacultyRepository;
import edu.northeastern.cs5200.jpas.Person;
import edu.northeastern.cs5200.jpas.PersonRepository;
import edu.northeastern.cs5200.jpas.Section;
import edu.northeastern.cs5200.jpas.SectionRepository;
import edu.northeastern.cs5200.jpas.Student;
import edu.northeastern.cs5200.jpas.StudentRepository;

@RestController
public class UniversityDao {

	public UniversityDao(){
		

	
	}
	

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	SectionRepository sectionRepository;
	@Autowired
	FacultyRepository facultyRepository;
	@Autowired
	PersonRepository personRepository;

	
	public void truncateDatabase() {
		studentRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		facultyRepository.deleteAll();
		personRepository.deleteAll();
	}
	
	public Person createPerson( Person person) {
		return personRepository.save(person);
	}
	public Faculty createFaculty( Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	
	public Student createStudent( Student student) {
		return studentRepository.save(student);
	}
	
	
	public Course createCourse( Course course) {
		return courseRepository.save(course);
	}
	
	
	public Section createSection( Section section) {
		return sectionRepository.save(section);
	}
	
	
	public Course addSectionToCourse(Section section, Course course) {
		course.addSection(section);
		section.setCourse(course);
		return courseRepository.save(course);
	}
	
	
	public Course setFacultyToCourse(Faculty faculty, Course course) {
		course.setFaculty(faculty);
		faculty.addCourse(course);
		return courseRepository.save(course);
	}
	

	public Boolean enrollStudentInSection(Student student,Section section) {
		if(section.getSeat() <=0) {
			return false;
		}
		else {
			int seat = section.getSeat();
			seat--;
			section.setSeat(seat);
			student.enrollSection(section);
			studentRepository.save(student);
			section.enrollStudent(student);
			sectionRepository.save(section);
			return true;
		}
		
	}
	@GetMapping("/api/test/user")
	public long findNumberOfUser() {
		return personRepository.count();
	}
	
	@GetMapping("/api/test/faculty")
	public long findNumberOfFaculty() {
		return facultyRepository.count();
	}
	
	@GetMapping("/api/test/student")
	public long findNumberOfStudent() {
		return studentRepository.count();
	}
	
	@GetMapping("/api/test/course")
	public long findNumberOfCourses() {
		return courseRepository.count();
	}
	
	@GetMapping("/api/test/section")
	public long findNumberOfSection() {
		return sectionRepository.count();
	}
	
	@GetMapping("/api/courses")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll();
	}
	
	@GetMapping("/api/faculty")
	public Iterable<Faculty> findAllFaculty() {
		return facultyRepository.findAll();
	}
	
	@GetMapping("/api/test/courseByFaculty")
	public Map<Integer,Integer> findAllCoursesByFaculty() {
		Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
		List<Faculty> faculty =(List<Faculty>)facultyRepository.findAll();
		for(Faculty f:faculty) {
			temp.put(f.getId(), f.getCourses().size());
		}
		
		return temp;
	}

	@GetMapping("/api/test/courseByFacultyName")
	public Map<String,Integer> findAllCoursesByFacultyName() {
		Map<String,Integer> temp = new HashMap<String,Integer>();
		List<Faculty> faculty =(List<Faculty>)facultyRepository.findAll();
		for(Faculty f:faculty) {
			temp.put(f.getFirstName()+" "+f.getLastName(), f.getCourses().size());
		}
		
		return temp;
	}
	
	@GetMapping("/api/test/sectionByCourse")
	public Map<String,Integer> findAllSectionByCourse() {
		Map<String,Integer> temp = new HashMap<String,Integer>();
		List<Course> courses =(List<Course>)courseRepository.findAll();
		for(Course c:courses) {
			if(c.getLabel()!=null) {
			temp.put(c.getLabel(), c.getSections().size());
			}

		}
		
		return temp;
	}
	
	@GetMapping("/api/test/studentBySection")
	public Map<String,Integer> findAllStudentBySection() {
		Map<String,Integer> temp = new HashMap<String,Integer>();
		List<Section> sections =(List<Section>)sectionRepository.findAll();
		for(Section s:sections) {
			temp.put(s.getTitle(), s.getEnrolledStudents().size());
		}
		
		return temp;
	}
	
	@GetMapping("/api/test/sectionByStudent")
	public Map<Integer,Integer> findAllSectionByStudent() {
		Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
		List<Student> students =(List<Student>)studentRepository.findAll();
		for(Student s:students) {
			temp.put(s.getId(), s.getEnrolledSections().size());
		}
		
		return temp;
	}

	@GetMapping("/api/test/seatBySection")
	public Map<String,Integer> findAllSeatBySection() {
		Map<String,Integer> temp = new HashMap<String,Integer>();
		List<Section> sections =(List<Section>)sectionRepository.findAll();
		for(Section s:sections) {
			temp.put(s.getTitle(), s.getSeat());
		}
		
		return temp;
	}
	
	@PostMapping("/api/test")
	public void test() {
		truncateDatabase();
		Faculty faculty1 = new Faculty("Alan","Turin","123A",true);
		Faculty faculty2 = new Faculty("Ada","Lovelace","123B",true);
		Student student1 = new Student("Alice","Wonderland",2020,12000);
		Student student2 = new Student("Bob","Hope",2021,23000);
		Student student3 = new Student("Charlie","Brown",2019,21000);
		Student student4 = new Student("Dan","Craig",2019,0);
		Student student5 = new Student("Edward","Scissorhands",2022,11000);
		Student student6 = new Student("Frand","Herbert",2018,0);
		Student student7 = new Student("Gregory","Peck",2023,10000);
	
		
		Course course1 = new Course("CS1234",faculty1);
		Course course2 = new Course("CS2345",faculty1);
		Course course3 = new Course("CS3456",faculty2);
		Course course4 = new Course("CS4567",faculty2);
		faculty1.addCourse(course1);
		faculty1.addCourse(course2);
		faculty2.addCourse(course3);
		faculty2.addCourse(course4);
		
		Section section1 = new Section("SEC4321",50,course1);
		section1.enrollStudent(student1);
		Section section2 = new Section("SEC5432",50,course1);
		section2.enrollStudent(student1);
		section2.enrollStudent(student2);
		Section section3 = new Section("SEC6543",50,course2);
		section3.enrollStudent(student3);
		Section section4 = new Section("SEC7654",50,course3);
		
		List<Section> sections1 = new ArrayList<Section>();
		List<Section> sections2 = new ArrayList<Section>();
		List<Section> sections3 = new ArrayList<Section>();
		sections1.add(section1);
		sections1.add(section2);
		sections2.add(section3);
		sections3.add(section4);
		course1.setSection(sections1);
		course2.setSection(sections2);
		course3.setSection(sections3);
		
		System.out.println("aaaaaaaaaaaaaa"+student1.getEnrolledSections().toString());

		createFaculty(faculty1);
		createFaculty(faculty2);
		createCourse(course1);
		createCourse(course2);
		createCourse(course3);
		createCourse(course4);

		createSection(section1);
		createSection(section2);
		createSection(section3);
		createSection(section4);

		createStudent(student1);
		createStudent(student2);
		createStudent(student3);
		createStudent(student4);
		createStudent(student5);
		createStudent(student6);
		createStudent(student7);

		
		
		
		
		
	}
}
