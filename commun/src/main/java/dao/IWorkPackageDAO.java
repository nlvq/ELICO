package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IWorkPackageDAO extends IHibernateDAO<Long, WorkPackage> {
	void createWorkPackage(WorkPackage wp);
	void updateWorkPackage(WorkPackage wp);
	void deleteWorkPackage(WorkPackage wp);
	List<WorkPackage> findWorkPackage(WorkPackage wp);
}
