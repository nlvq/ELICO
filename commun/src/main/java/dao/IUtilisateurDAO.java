package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IUtilisateurDAO extends IHibernateDAO<Long, Utilisateur> {
	void createUtilisateur(Utilisateur utilisateur);
	void updateUtilisateur(Utilisateur utilisateur);
	void deleteUtilisateur(Utilisateur utilisateur);
	List<Utilisateur> findUtilisateur(Utilisateur utilisateur);
}
