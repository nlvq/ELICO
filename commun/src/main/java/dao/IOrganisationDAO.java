package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IOrganisationDAO extends IHibernateDAO<Long, Organisation> {
	void createOrganisation(Organisation organisation);
	void updateOrganisation(Organisation organisation);
	void deleteOrganisation(Organisation organisation);
	List<Organisation> findOrganisation(Organisation organisation);
}
