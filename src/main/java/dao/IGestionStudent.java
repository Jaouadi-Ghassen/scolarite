package dao;

import java.util.List;

import dao.entities.Student;

public interface IGestionStudent {
	
	public void addStudent(Student S );
	public String getStudentName(String email, String password);
	public void deleteStudent(Student s);
	public void updateStudent(Student s);
	public Student getStudentById(int id);
	public List<Student> getAllStudent();
	public List<Student> getStudentByMc(String mc);
	public int getStudentCount();
	public List<Student> getAllStudent(int offset, int limit);
}
