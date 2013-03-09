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
public class TestVersionDAO extends TestAbstractDAO <Long, Version> {

	@Autowired
	private IVersionDAO versionDAO;

	@Override
	protected IDAO<Long, Version> getIDAO(){
		return versionDAO;
	}

	@Override
	protected long countAll() {
		return 2;
	}
	
	@Test
	public void testFindById(){
		Version version = versionDAO.findById(1L);
		Assert.assertEquals(version.getNumber(), "1.0");
	}
	
	@Test
	public void testFindByVersion(){
		Version toFind = new Version();
		toFind.setId(1L);
		toFind.setNumber("1.0");
		List<Version> version = versionDAO.findVersion(toFind);
		Assert.assertEquals(version.size(), 1);
		Assert.assertEquals(version.get(0).getNumber(), "1.0");
	}
	
	@Test
	public void testUpdate(){
		Version toRefresh = versionDAO.findById(1L);
		toRefresh.setNumber("1.0.1");
		versionDAO.updateVersion(toRefresh);
		
		Version version = versionDAO.findById(1L);
		Assert.assertEquals(version.getNumber(), "1.0.1");
	}
	
	@Test
	public void testCreate(){
		Version toCreate = new Version();
		toCreate.setNumber("3.0");
		versionDAO.createVersion(toCreate);
		
		Version version = versionDAO.findVersion(toCreate).get(0);
		Assert.assertEquals(version.getNumber(), "3.0");
	}
	
	@Test
	public void testDelete(){
		Version toDelete = versionDAO.findById(1L);
		versionDAO.deleteVersion(toDelete);
		
		Version version = versionDAO.findById(1L);
		Assert.assertNull(version);
	}
			
}
