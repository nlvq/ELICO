package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IObjetDAO extends IHibernateDAO<Long, Objet> {
	void createObjet(Objet objet);
	void updateObjet(Objet objet);
	void deleteObjet(Objet objet);
	List<Objet> findObjet(Objet objet);
}
