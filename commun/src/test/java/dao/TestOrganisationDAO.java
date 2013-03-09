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
public class TestOrganisationDAO extends TestAbstractDAO <Long, Organisation> {

	@Autowired
	private IOrganisationDAO organisationDAO;

	@Override
	protected IDAO<Long, Organisation> getIDAO(){
		return organisationDAO;
	}

	@Override
	protected long countAll() {
		return 2;
	}
	
	@Test
	public void testFindById(){
		Organisation organisation = organisationDAO.findById(1L);
		Assert.assertEquals(organisation.getTitle(), "org1");
		Assert.assertEquals(organisation.getType(), "enterprise");
	}
	
	@Test
	public void testFindByOrganisation(){
		Organisation toFind = new Organisation();
		toFind.setId(1L);
		toFind.setTitle("org1");
		List<Organisation> organisation = organisationDAO.findOrganisation(toFind);
		Assert.assertEquals(organisation.size(), 1);
		Assert.assertEquals(organisation.get(0).getTitle(), "org1");
	}
	
	@Test
	public void testUpdate(){
		Organisation toRefresh = organisationDAO.findById(1L);
		toRefresh.setTitle("org100");
		organisationDAO.updateOrganisation(toRefresh);
		
		Organisation organisation = organisationDAO.findById(1L);
		Assert.assertEquals(organisation.getTitle(), "org100");
	}
	
	@Test
	public void testCreate(){
		Organisation toCreate = new Organisation();
		toCreate.setTitle("org3");
		toCreate.setType("enterprise");
		organisationDAO.createOrganisation(toCreate);
		
		Organisation organisation = organisationDAO.findOrganisation(toCreate).get(0);
		Assert.assertEquals(organisation.getTitle(), "org3");
	}
	
	@Test
	public void testDelete(){
		Organisation toDelete = organisationDAO.findById(1L);
		organisationDAO.deleteOrganisation(toDelete);
		
		Organisation organisation = organisationDAO.findById(1L);
		Assert.assertNull(organisation);
	}
			
}
