package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IUtilisateurOrganisationRoleDAO extends IHibernateDAO<Long, UtilisateurOrganisationRole> {
	void createUtilisateurOrganisationRole(UtilisateurOrganisationRole uor);
	void updateUtilisateurOrganisationRole(UtilisateurOrganisationRole uor);
	void deleteUtilisateurOrganisationRole(UtilisateurOrganisationRole uor);
	List<UtilisateurOrganisationRole> findUtilisateurOrganisationRole(UtilisateurOrganisationRole uor);
}
