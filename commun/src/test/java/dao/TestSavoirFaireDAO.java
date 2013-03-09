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
public class TestSavoirFaireDAO extends TestAbstractDAO <Long, SavoirFaire> {

	@Autowired
	private ISavoirFaireDAO savoirFaireDAO;

	@Override
	protected IDAO<Long, SavoirFaire> getIDAO(){
		return savoirFaireDAO;
	}

	@Override
	protected long countAll() {
		return 2;
	}
	
	@Test
	public void testFindById(){
		SavoirFaire savoirFaire = savoirFaireDAO.findById(1L);
		Assert.assertEquals(savoirFaire.getTitle(), "reader");
	}
	
	@Test
	public void testFindBySavoirFaire(){
		SavoirFaire toFind = new SavoirFaire();
		toFind.setId(1L);
		toFind.setTitle("reader");
		List<SavoirFaire> savoirFaire = savoirFaireDAO.findSavoirFaire(toFind);
		Assert.assertEquals(savoirFaire.size(), 1);
		Assert.assertEquals(savoirFaire.get(0).getTitle(), "reader");
	}
	
	@Test
	public void testUpdate(){
		SavoirFaire toRefresh = savoirFaireDAO.findById(1L);
		toRefresh.setTitle("readerrrrr");
		savoirFaireDAO.updateSavoirFaire(toRefresh);
		
		SavoirFaire savoirFaire = savoirFaireDAO.findById(1L);
		Assert.assertEquals(savoirFaire.getTitle(), "readerrrrr");
	}
	
	@Test
	public void testCreate(){
		SavoirFaire toCreate = new SavoirFaire();
		toCreate.setTitle("supervisor");
		savoirFaireDAO.createSavoirFaire(toCreate);
		
		SavoirFaire savoirFaire = savoirFaireDAO.findSavoirFaire(toCreate).get(0);
		Assert.assertEquals(savoirFaire.getTitle(), "supervisor");
	}
	
	@Test
	public void testDelete(){
		SavoirFaire toDelete = savoirFaireDAO.findById(1L);
		savoirFaireDAO.deleteSavoirFaire(toDelete);
		
		SavoirFaire savoirFaire = savoirFaireDAO.findById(1L);
		Assert.assertNull(savoirFaire);
	}
			
}
