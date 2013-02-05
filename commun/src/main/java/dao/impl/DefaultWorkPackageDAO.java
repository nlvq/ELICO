package dao.impl;

import java.util.List;

import dao.IWorkPackageDAO;
import dao.WorkPackage;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

public class DefaultWorkPackageDAO extends AbstractHibernateDAO<Long, WorkPackage> implements IWorkPackageDAO {

	@Override
	public void createWorkPackage(WorkPackage wp) {
		persist(wp);
	}

	@Override
	public void updateWorkPackage(WorkPackage wp) {
	}

	@Override
	public void deleteWorkPackage(WorkPackage wp) {
		
	}

	@Override
	public List<WorkPackage> findWorkPackage(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
