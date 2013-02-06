package dao.impl;

import java.util.List;

import dao.IVersionDAO;
import dao.Version;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultVersionDAO extends AbstractHibernateDAO<Long, Version> implements IVersionDAO {

	@Override
	public void createVersion(Version version) {
		persist(version);
	}

	@Override
	public void updateVersion(Version version) {
		merge(version);
	}

	@Override
	public void deleteVersion(Version version) {
		remove(version);
	}

	@Override
	public List<Version> findVersion(Version version) {
		return findByExample(version, new String[0]);
	}

}
