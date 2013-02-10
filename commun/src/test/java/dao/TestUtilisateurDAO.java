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
public class TestUtilisateurDAO extends TestAbstractDAO <Long, Utilisateur> {

	@Autowired
	private IUtilisateurDAO utilisateurDAO;

	@Override
	protected IDAO<Long, Utilisateur> getIDAO(){
		return utilisateurDAO;
	}

	@Override
	protected long countAll() {
		return 4;
	}
	
	@Test
	public void testFindById(){
		Utilisateur utilisateur = utilisateurDAO.findById(1L);
		Assert.assertEquals(utilisateur.getLogin(), "toto1");
		Assert.assertEquals(utilisateur.getPassword(), "pwd");
		Assert.assertEquals(utilisateur.getLastName(), "t1");
		Assert.assertEquals(utilisateur.getFirstName(), "oto");
		Assert.assertEquals(utilisateur.getPhoneNumber(), "0123456789");
	}
	
	@Test
	public void testFindByUtilisateur(){
		Utilisateur toFind = new Utilisateur();
		toFind.setId(1L);
		toFind.setLogin("toto1");
		List<Utilisateur> utilisateur = utilisateurDAO.findUtilisateur(toFind);
		Assert.assertEquals(utilisateur.size(), 1);
		Assert.assertEquals(utilisateur.get(0).getLogin(), "toto1");
	}
	
	@Test
	public void testFindByUtilisateurMult(){
		Utilisateur toFind = new Utilisateur();
		toFind.setFirstName("oto");
		toFind.setLogin(null);
		List<Utilisateur> utilisateur = utilisateurDAO.findUtilisateur(toFind);
		Assert.assertEquals(utilisateur.size(), 4);
	}
	
	@Test
	public void testUpdate(){
		Utilisateur toRefresh = utilisateurDAO.findById(1L);
		toRefresh.setFirstName("totototo");
		utilisateurDAO.updateUtilisateur(toRefresh);
		
		Utilisateur utilisateur = utilisateurDAO.findById(1L);
		Assert.assertEquals(utilisateur.getFirstName(), "totototo");
	}
	
	@Test
	public void testCreate(){
		Utilisateur toCreate = new Utilisateur();
		toCreate.setLogin("toto5");
		toCreate.setLastName("t5");
		toCreate.setFirstName("oto");
		utilisateurDAO.createUtilisateur(toCreate);
		
		Utilisateur utilisateur = utilisateurDAO.findById(5L);
		Assert.assertEquals(utilisateur.getLogin(), "toto5");
	}
	
	@Test
	public void testDelete(){
		Utilisateur toDelete = utilisateurDAO.findById(1L);
		utilisateurDAO.deleteUtilisateur(toDelete);
		
		Utilisateur utilisateur = utilisateurDAO.findById(1L);
		Assert.assertNull(utilisateur);
	}
			
}
