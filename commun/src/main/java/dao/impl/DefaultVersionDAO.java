package dao.impl;

import dao.Version;
import dao.IVersionDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultVersionDAO extends AbstractHibernateDAO<Long, Version> implements IVersionDAO {

}
