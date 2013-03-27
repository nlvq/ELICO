package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.IOrganisationDAO;
import dao.Organisation;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultOrganisationDAO extends AbstractHibernateDAO<Long, Organisation> implements IOrganisationDAO {

	@Override
	public void createOrganisation(Organisation organisation) {
		persist(organisation);
	}

	@Override
	public void updateOrganisation(Organisation organisation) {
		merge(organisation);
	}

	@Override
	public void deleteOrganisation(Organisation organisation) {
		remove(organisation);
	}

	@Override
	public List<Organisation> findOrganisation(Organisation organisation) {
		return findByExample(organisation, new String[0]);
	}

}
