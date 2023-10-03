package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GestionUserlmp implements IGestionUser {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghassen");
	EntityManager em = emf.createEntityManager();


	@Override
	public String getUserName(String email, String password) {
		Query q = em.createQuery("SELECT e.username FROM dao.entities.User e WHERE e.email = ?1 AND e.password = ?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		String username = (String) q.getSingleResult();
		return username;
	}
	
}
