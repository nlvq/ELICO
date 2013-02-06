package dao.impl;

import java.util.List;

import dao.ISavoirFaireDAO;
import dao.SavoirFaire;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultSavoirFaireDAO extends AbstractHibernateDAO<Long, SavoirFaire> implements ISavoirFaireDAO {

	@Override
	public void createSavoirFaire(SavoirFaire savoirFaire) {
		persist(savoirFaire);
	}

	@Override
	public void updateSavoirFaire(SavoirFaire savoirFaire) {
		merge(savoirFaire);
	}

	@Override
	public void deleteSavoirFaire(SavoirFaire savoirFaire) {
		remove(savoirFaire);
	}

	@Override
	public List<SavoirFaire> findSavoirFaire(SavoirFaire savoirFaire) {
		return findByExample(savoirFaire, new String[0]);
	}

}
