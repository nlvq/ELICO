package dao;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IOrganisationDAO extends IHibernateDAO<Long, Organisation> {

	Organisation getOrganisation(String name);

}
