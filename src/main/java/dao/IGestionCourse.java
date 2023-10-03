package dao;

import java.util.List;

import dao.entities.Course;


public interface IGestionCourse {
	
	public void addCourse(Course C);
	public void deleteCourse(Course C);
	public void updateCourse(Course C);
	public List<Course> getAllCourse();
	public List<Course> getCourseByMc(String mc);
	public Course getCourseById(int id);

	
	

}
