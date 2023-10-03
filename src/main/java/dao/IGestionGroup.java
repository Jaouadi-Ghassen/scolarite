package dao;

import java.util.List;

import dao.entities.Groupe;

public interface IGestionGroup {
	public void AddGroup(Groupe p);
	public Groupe getGroupe(int id);
	public List<Groupe> getAllGroupes();
	public void DeletGr(Groupe p);
}
