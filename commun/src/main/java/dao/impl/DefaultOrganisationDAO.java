package dao.impl;

import dao.Organisation;
import dao.IOrganisationDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultOrganisationDAO extends AbstractHibernateDAO<Long, Organisation> implements IOrganisationDAO {

	@Override
	public Organisation getOrganisation(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
