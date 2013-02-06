package dao.impl;

import java.util.List;

import dao.IUtilisateurDAO;
import dao.Utilisateur;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultUtilisateurDAO extends AbstractHibernateDAO<Long, Utilisateur> implements IUtilisateurDAO {

	@Override
	public void createUtilisateur(Utilisateur utilisateur) {
		persist(utilisateur);
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		merge(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		remove(utilisateur);
	}

	@Override
	public List<Utilisateur> findUtilisateur(Utilisateur utilisateur) {
		return findByExample(utilisateur, new String[0]);
	}

}
