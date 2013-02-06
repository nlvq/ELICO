package dao.impl;

import dao.IVersionDAO;
import dao.Version;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultVersionDAO extends AbstractHibernateDAO<Long, Version> implements IVersionDAO {

}
