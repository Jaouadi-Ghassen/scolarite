 package dao.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Groupe {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@OneToMany(mappedBy = "group",cascade = CascadeType.ALL)
    private List<Student>students;
	
	@ManyToMany
	private List<Course> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Groupe(String nom, List<Student> students) {
		super();
		this.nom = nom;
		this.students = students;
	}
	public Groupe() {
		super();
	}
	public Groupe(int id, String nom, List<Student> students) {
		super();
		this.id = id;
		this.nom = nom;
		this.students = students;
	}
	public Groupe(String nom) {
		super();
		this.nom = nom;
	}
	
	
	

}
