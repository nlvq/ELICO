package dao.impl;

import java.util.List;

import dao.IObjetDAO;
import dao.Objet;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultObjetDAO extends AbstractHibernateDAO<Long, Objet> implements IObjetDAO {

	@Override
	public void createObjet(Objet objet) {
		persist(objet);
	}

	@Override
	public void updateObjet(Objet objet) {
		merge(objet);
	}

	@Override
	public void deleteObjet(Objet objet) {
		remove(objet);
	}

	@Override
	public List<Objet> findObjet(Objet objet) {
		return findByExample(objet, new String[0]);
	}

}
