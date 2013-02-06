package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IMaturiteDAO extends IHibernateDAO<Long, Maturite> {
	void createMaturite(Maturite maturite);
	void updateMaturite(Maturite maturite);
	void deleteMaturite(Maturite maturite);
	List<Maturite> findMaturite(Maturite maturite);
}
