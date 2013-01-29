package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;



public interface IWorkSpaceDAO extends IHibernateDAO<Long, WorkSpace> {
	void createWorkSpace(WorkSpace ws);
	void updateWorkSpace(WorkSpace ws);
	void deleteWorkSpace(WorkSpace ws);
	List<WorkSpace> findWorkSpace(String id);
}
