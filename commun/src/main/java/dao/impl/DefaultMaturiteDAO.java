package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.IMaturiteDAO;
import dao.Maturite;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultMaturiteDAO extends AbstractHibernateDAO<Long, Maturite> implements IMaturiteDAO {

	@Override
	public void createMaturite(Maturite maturite) {
		persist(maturite);
	}

	@Override
	public void updateMaturite(Maturite maturite) {
		merge(maturite);
	}

	@Override
	public void deleteMaturite(Maturite maturite) {
		remove(maturite);
	}

	@Override
	public List<Maturite> findMaturite(Maturite maturite) {
		return findByExample(maturite, new String[0]);
	}

}
