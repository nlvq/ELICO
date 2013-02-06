package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IVersionDAO extends IHibernateDAO<Long, Version> {
	void createVersion(Version version);
	void updateVersion(Version version);
	void deleteVersion(Version version);
	List<Version> findVersion(Version version);
}
