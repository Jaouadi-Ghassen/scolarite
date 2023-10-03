package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.entities.Course;

public class GestionCourseImp implements IGestionCourse{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghassen");
	
	
	EntityManager em = emf.createEntityManager();
	@Override
	public void addCourse(Course C) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(C);
		et.commit();
		
	}

	@Override
	public void deleteCourse(Course C) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(C);
		et.commit();
		
	}

	@Override
	public void updateCourse(Course C) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(C);
		et.commit();		
	}


	@Override
	public Course getCourseById(int id) {
		return em.find(Course.class, id);
	}

	@Override
	public List<Course> getAllCourse() {
		Query q = em.createQuery("select p from Course p");
		return q.getResultList();
	}

	@Override
	public List<Course> getCourseByMc(String mc) {
		Query q = em.createQuery("select p from Course where p.nom like :x");
		q.setParameter("x", mc);
		return q.getResultList();
	}
	
	

	

	

}
