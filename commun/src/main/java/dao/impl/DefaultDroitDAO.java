package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.Droit;
import dao.IDroitDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultDroitDAO extends AbstractHibernateDAO<Long, Droit> implements IDroitDAO {

	@Override
	public void createDroit(Droit droit) {
		persist(droit);
	}

	@Override
	public void updateDroit(Droit droit) {
		merge(droit);
	}

	@Override
	public void deleteDroit(Droit droit) {
		remove(droit);
	}

	@Override
	public List<Droit> findDroit(Droit droit) {
		return findByExample(droit, new String[0]);
	}

}
