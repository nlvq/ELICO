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
public class TestObjetDAO extends TestAbstractDAO <Long, Objet> {

	@Autowired
	private IObjetDAO objetDAO;

	@Override
	protected IDAO<Long, Objet> getIDAO(){
		return objetDAO;
	}

	@Override
	protected long countAll() {
		return 2;
	}
	
	@Test
	public void testFindById(){
		Objet objet = objetDAO.findById(1L);
		Assert.assertEquals(objet.getType(), "text");
		Assert.assertEquals(objet.getDescription(), "desc");
		Assert.assertEquals(objet.getContent(), "aaaaa");
		Assert.assertEquals(objet.getMaturite().getTitle(), Etat.NUL);
	}
	
	@Test
	public void testFindByObjet(){
		Objet toFind = new Objet();
		toFind.setId(1L);
		toFind.setContent("aaaaa");
		List<Objet> objet = objetDAO.findObjet(toFind);
		Assert.assertEquals(objet.size(), 1);
		Assert.assertEquals(objet.get(0).getContent(), "aaaaa");
	}
	
	@Test
	public void testUpdate(){
		Objet toRefresh = objetDAO.findById(1L);
		toRefresh.setContent("aaaaa zzzz");
		objetDAO.updateObjet(toRefresh);
		
		Objet objet = objetDAO.findById(1L);
		Assert.assertEquals(objet.getContent(), "aaaaa zzzz");
	}
	
	@Test
	public void testCreate(){
		Objet toCreate = new Objet();
		toCreate.setType("text");
		toCreate.setDescription("desccc");
		toCreate.setContent("g g g");
		objetDAO.createObjet(toCreate);
		
		Objet objet = objetDAO.findById(3L);
		Assert.assertEquals(objet.getContent(), "g g g");
	}
	
	@Test
	public void testDelete(){
		Objet toDelete = objetDAO.findById(1L);
		objetDAO.deleteObjet(toDelete);
		
		Objet objet = objetDAO.findById(1L);
		Assert.assertNull(objet);
	}
			
}
