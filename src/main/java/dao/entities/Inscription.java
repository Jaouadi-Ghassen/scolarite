package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inscription {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dateIns;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Course course;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateIns() {
		return dateIns;
	}

	public void setDateIns(String dateIns) {
		this.dateIns = dateIns;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Inscription(int id, String dateIns, Student student, Course course) {
		super();
		this.id = id;
		this.dateIns = dateIns;
		this.student = student;
		this.course = course;
	}

	public Inscription(String dateIns, Student student, Course course) {
		super();
		this.dateIns = dateIns;
		this.student = student;
		this.course = course;
	}

	public Inscription() {
		super();
	}
	
	

}
