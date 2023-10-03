package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import dao.entities.Student;


public class GestionStudentImp implements IGestionStudent{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghassen");
	EntityManager em = emf.createEntityManager();

	@Override
	public void addStudent(Student S) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(S);
		et.commit();	
		
	}

	@Override
	public String getStudentName(String email, String password) {
		Query q = em.createQuery("SELECT e.username FROM dao.entities.Student e WHERE e.email = ?1 AND e.password = ?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		String username = (String) q.getSingleResult();
		return username;
	}

	@Override
	public void deleteStudent(Student S) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(S);
		et.commit();
	}

	@Override
	public Student getStudentById(int id) {
		return em.find(Student.class, id);
	}

	@Override
	public List<Student> getAllStudent() {
		Query q = em.createQuery("select s from Student s");
		return q.getResultList();
	}
	
	public List<Student> getStudentByMc(String mc) {
		Query q = em.createQuery("select p from dao.entities.Student p where p.username like :x");
		q.setParameter("x", mc);
		return q.getResultList();
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(s);
		et.commit();	
	}
	
	public int getStudentCount() {
		Query q = em.createQuery("select count(*) from Student s");
	    Long count = (Long) q.getSingleResult();
	    return count.intValue();
	}
	
	public List<Student> getAllStudent(int offset, int limit) {
        Query q = em.createQuery("SELECT s FROM Student s ORDER BY s.id ASC");
        q.setFirstResult(offset);
        q.setMaxResults(limit);
        List<Student> students = q.getResultList();
        return students;
}


}
