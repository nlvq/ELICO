package dao;

import java.util.List;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;

public interface IRoleDAO extends IHibernateDAO<Long, Role> {
	void createRole(Role role);
	void updateRole(Role role);
	void deleteRole(Role role);
	List<Role> findRole(Role role);
}
