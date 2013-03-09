package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dao.Droit.LDroit;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class TestDroitDAO extends TestAbstractDAO <Long, Droit> {

	@Autowired
	private IDroitDAO droitDAO;

	@Override
	protected IDAO<Long, Droit> getIDAO(){
		return droitDAO;
	}

	@Override
	protected long countAll() {
		return 3;
	}
	
	@Test
	public void testFindById(){
		Droit droit = droitDAO.findById(1L);
		Assert.assertEquals(droit.getTitle(), LDroit.Read);
	}
	
	@Test
	public void testFindByDroit(){
		Droit toFind = new Droit();
		toFind.setId(1L);
		toFind.setTitle(LDroit.Read);
		List<Droit> droit = droitDAO.findDroit(toFind);
		Assert.assertEquals(droit.size(), 1);
		Assert.assertEquals(droit.get(0).getTitle(), LDroit.Read);
	}
	
	@Test
	public void testUpdate(){
		Droit toRefresh = droitDAO.findById(1L);
		toRefresh.setTitle(LDroit.Write);
		droitDAO.updateDroit(toRefresh);
		
		Droit droit = droitDAO.findById(1L);
		Assert.assertEquals(droit.getTitle(), LDroit.Write);
	}
	
	@Test
	public void testCreate(){
		Droit toCreate = new Droit();
		toCreate.setTitle(LDroit.Block);
		droitDAO.createDroit(toCreate);
		
		Droit droit = droitDAO.findDroit(toCreate).get(0);
		Assert.assertEquals(droit.getTitle(), LDroit.Block);
	}
	
	@Test
	public void testDelete(){
		Droit toDelete = droitDAO.findById(1L);
		droitDAO.deleteDroit(toDelete);
		
		Droit droit = droitDAO.findById(1L);
		Assert.assertNull(droit);
	}
			
}
