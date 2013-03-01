package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.IUtilisateurOrganisationRoleDAO;
import dao.UtilisateurOrganisationRole;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultUtilisateurOrganisationRoleDAO extends AbstractHibernateDAO<Long, UtilisateurOrganisationRole> implements IUtilisateurOrganisationRoleDAO {

	@Override
	public void createUtilisateurOrganisationRole(UtilisateurOrganisationRole uor) {
		persist(uor);
	}

	@Override
	public void updateUtilisateurOrganisationRole(UtilisateurOrganisationRole uor) {
		merge(uor);
	}

	@Override
	public void deleteUtilisateurOrganisationRole(UtilisateurOrganisationRole uor) {
		remove(uor);
	}

	@Override
	public List<UtilisateurOrganisationRole> findUtilisateurOrganisationRole(UtilisateurOrganisationRole uor) {
		return findByExample(uor, new String[0]);
	}

}
