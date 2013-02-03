package dao;

import dao.Droit.LDroit;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IDroitDAO extends IHibernateDAO<Long, Droit> {

	Droit findDroit(LDroit write);

}
