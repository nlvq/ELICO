package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.IWorkPackageDAO;
import dao.WorkPackage;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultWorkPackageDAO extends AbstractHibernateDAO<Long, WorkPackage> implements IWorkPackageDAO {

	@Override
	public void createWorkPackage(WorkPackage wp) {
		persist(wp);
	}

	@Override
	public void updateWorkPackage(WorkPackage wp) {
		merge(wp);
	}

	@Override
	public void deleteWorkPackage(WorkPackage wp) {
		remove(wp);
	}

	@Override
	public List<WorkPackage> findWorkPackage(WorkPackage wp) {
		return findByExample(wp, new String[0]);
	}

}
