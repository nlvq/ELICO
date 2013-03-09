package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class TestRoleDAO extends TestAbstractDAO <Long, Role> {

	@Autowired
	private IRoleDAO roleDAO;

	@Override
	protected IDAO<Long, Role> getIDAO(){
		return roleDAO;
	}

	@Override
	protected long countAll() {
		return 2;
	}
	
	@Test
	public void testFindById(){
		Role role = roleDAO.findById(1L);
		Assert.assertEquals(role.getTitle(), "reader");
	}
	
	@Test
	public void testFindByRole(){
		Role toFind = new Role();
		toFind.setId(1L);
		toFind.setTitle("reader");
		List<Role> role = roleDAO.findRole(toFind);
		Assert.assertEquals(role.size(), 1);
		Assert.assertEquals(role.get(0).getTitle(), "reader");
	}
	
	@Test
	public void testUpdate(){
		Role toRefresh = roleDAO.findById(1L);
		toRefresh.setTitle("readerrrrr");
		roleDAO.updateRole(toRefresh);
		
		Role role = roleDAO.findById(1L);
		Assert.assertEquals(role.getTitle(), "readerrrrr");
	}
	
	@Test
	public void testCreate(){
		Role toCreate = new Role();
		toCreate.setTitle("supervisor");
		roleDAO.createRole(toCreate);
		
		Role role = roleDAO.findRole(toCreate).get(0);
		Assert.assertEquals(role.getTitle(), "supervisor");
	}
	
	@Test
	public void testDelete(){
		Role toDelete = roleDAO.findById(1L);
		roleDAO.deleteRole(toDelete);
		
		Role role = roleDAO.findById(1L);
		Assert.assertNull(role);
	}
			
}
