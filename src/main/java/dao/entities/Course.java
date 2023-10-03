package dao.entities;




import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany
	private List<Groupe> group ;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}


	public Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}
	
	
	
	
	
}
