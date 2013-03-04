package dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import dao.IRoleDAO;
import dao.Role;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DefaultRoleDAO extends AbstractHibernateDAO<Long, Role> implements IRoleDAO {

	@Override
	public void createRole(Role role) {
		persist(role);
	}

	@Override
	public void updateRole(Role role) {
		merge(role);
	}

	@Override
	public void deleteRole(Role role) {
		remove(role);
	}

	@Override
	public List<Role> findRole(Role role) {
		return findByExample(role, new String[0]);
	}

}
