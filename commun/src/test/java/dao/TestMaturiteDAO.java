package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dao.Maturite.Etat;

import fr.umlv.m2.jee.dao.IDAO;
import fr.umlv.m2.jee.dao.TestAbstractDAO;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class TestMaturiteDAO extends TestAbstractDAO <Long, Maturite> {

	@Autowired
	private IMaturiteDAO maturiteDAO;

	@Override
	protected IDAO<Long, Maturite> getIDAO(){
		return maturiteDAO;
	}

	@Override
	protected long countAll() {
		return 2;
	}
	
	@Test
	public void testFindById(){
		Maturite maturite = maturiteDAO.findById(1L);
		Assert.assertEquals(maturite.getTitle(), Etat.NUL);
		Assert.assertEquals(maturite.getCommentary(), "comm");
	}
	
	@Test
	public void testFindByMaturite(){
		Maturite toFind = new Maturite();
		toFind.setId(1L);
		toFind.setTitle(Etat.NUL);
		List<Maturite> maturite = maturiteDAO.findMaturite(toFind);
		Assert.assertEquals(maturite.size(), 1);
		Assert.assertEquals(maturite.get(0).getTitle(), Etat.NUL);
	}
	
	@Test
	public void testUpdate(){
		Maturite toRefresh = maturiteDAO.findById(1L);
		toRefresh.setTitle(Etat.ASKVALID);
		maturiteDAO.updateMaturite(toRefresh);
		
		Maturite maturite = maturiteDAO.findById(1L);
		Assert.assertEquals(maturite.getTitle(), Etat.ASKVALID);
	}
	
	@Test
	public void testCreate(){
		Maturite toCreate = new Maturite();
		toCreate.setTitle(Etat.NUL);
		toCreate.setCommentary("comm");
		maturiteDAO.createMaturite(toCreate);
		
		Maturite maturite = maturiteDAO.findById(3L);
		Assert.assertEquals(maturite.getTitle(), Etat.NUL);
	}
	
	@Test
	public void testDelete(){
		Maturite toDelete = maturiteDAO.findById(1L);
		maturiteDAO.deleteMaturite(toDelete);
		
		Maturite maturite = maturiteDAO.findById(1L);
		Assert.assertNull(maturite);
	}
			
}
