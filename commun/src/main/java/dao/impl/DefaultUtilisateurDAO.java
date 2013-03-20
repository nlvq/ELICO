package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.IUtilisateurDAO;
import dao.Utilisateur;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultUtilisateurDAO extends AbstractHibernateDAO<Long, Utilisateur> implements IUtilisateurDAO {

	@Override
	public void createUtilisateur(Utilisateur utilisateur) {
		Utilisateur u = new Utilisateur();
		u.setLogin(utilisateur.getLogin());
		List<Utilisateur> found = findUtilisateur(u);
		if(found == null || found.isEmpty()){
			persist(utilisateur);
		}
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
