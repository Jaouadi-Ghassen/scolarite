package dao.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Student {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	private String phone;
	private String datens;
	private String adresse;
	@ManyToOne
	private Groupe group;
	private String file;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDatens() {
		return datens;
	}

	public void setDatens(String datens) {
		this.datens = datens;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Groupe getGroup() {
		return group;
	}

	public void setGroup(Groupe group) {
		this.group = group;
	}



/*	public Student(int id, String username, String email, String password, Groupe group, List<Course> courses) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.group = group;
		this.courses = courses;
	}

	public Student(String username, String email, String password, Groupe group, List<Course> courses) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.group = group;
		this.courses = courses;
	}

	public Student() {
		super();
	}
*/
	public Student(String username, String email, String password, Groupe group) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.group = group;
	}

	public Student() {
		super();
	}



	public Student(String username, String email, String password, String phone, String datens, String adresse,
			Groupe group) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.datens = datens;
		this.adresse = adresse;
		this.group = group;
	}


	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Student(String username, String email, String password, String phone, String datens, String adresse,
			Groupe group, String file) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.datens = datens;
		this.adresse = adresse;
		this.group = group;
		this.file = file;
	}

	public Student(int id, String username, String email, String password, String phone, String datens, String adresse,
			Groupe group, String file) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.datens = datens;
		this.adresse = adresse;
		this.group = group;
		this.file = file;
	}

	public Student(int id, String username, String email, String password, String phone, String datens, String adresse,
			Groupe group) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.datens = datens;
		this.adresse = adresse;
		this.group = group;
	}
	
	

	
	
	
	
	

	
	
	
	
	
}
