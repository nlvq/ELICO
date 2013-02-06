package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface ISavoirFaireDAO extends IHibernateDAO<Long, SavoirFaire> {
	void createSavoirFaire(SavoirFaire savoirFaire);
	void updateSavoirFaire(SavoirFaire savoirFaire);
	void deleteSavoirFaire(SavoirFaire savoirFaire);
	List<SavoirFaire> findSavoirFaire(SavoirFaire savoirFaire);
}
