package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.IWorkSpaceDAO;
import dao.WorkSpace;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultWorkSpaceDAO extends AbstractHibernateDAO<Long, WorkSpace> implements IWorkSpaceDAO {

	@Override
	public void createWorkSpace(WorkSpace ws) {
		persist(ws);
	}

	@Override
	public void updateWorkSpace(WorkSpace ws) {
		merge(ws);
	}

	@Override
	public void deleteWorkSpace(WorkSpace ws) {
		remove(ws);
	}

	@Override
	public List<WorkSpace> findWorkSpace(WorkSpace ws) {
		return findByExample(ws, new String[0]);
	}

}
