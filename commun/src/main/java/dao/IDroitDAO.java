package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IDroitDAO extends IHibernateDAO<Long, Droit> {
	void createDroit(Droit droit);
	void updateDroit(Droit droit);
	void deleteDroit(Droit droit);
	List<Droit> findDroit(Droit droit);
}
