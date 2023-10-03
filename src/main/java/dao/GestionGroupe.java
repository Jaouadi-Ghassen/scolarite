package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.entities.Groupe;



public class GestionGroupe implements IGestionGroup {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghassen");
	EntityManager em = emf.createEntityManager();
	
	
	@Override
	public Groupe getGroupe(int id) {
		return em.find(Groupe.class, id);
	}

	@Override
	public List<Groupe> getAllGroupes() {
		Query q = em.createQuery("select c from Groupe c");
		return q.getResultList();
	}

	@Override
	public void AddGroup(Groupe p) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();	
	}

	@Override
	public void DeletGr(Groupe p) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(p);
		et.commit();
	}




}
