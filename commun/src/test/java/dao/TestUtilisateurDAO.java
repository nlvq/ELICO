package dao;

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
		return 1;
	}
	
	/*@Test
	public void testFindBySsid(){
		Author author = utilisateurDAO.findBySsid("1");
		Assert.assertEquals(author.getFirstname(), "test");
		Assert.assertEquals(author.getLastname(), "toto");
	}
	
	@Test
	public void testFindByBirthday(){
		Author author = utilisateurDAO.findByBirthday("2000-03-14").get(0);
		Assert.assertEquals(author.getFirstname(), "test");
		Assert.assertEquals(author.getLastname(), "toto");
	}
	
	@Test
	public void testFindByDead(){
		Author author = utilisateurDAO.findByDead("2012-03-15").get(0);
		Assert.assertEquals(author.getFirstname(), "test");
		Assert.assertEquals(author.getLastname(), "tata");
	}
	
	@Test
	public void testUpdate(){
		Author toRefresh = utilisateurDAO.findBySsid("1");
		toRefresh.setFirstname("totototo");
		utilisateurDAO.merge(toRefresh);
		
		Author author = utilisateurDAO.findBySsid("1");
		Assert.assertEquals(author.getFirstname(), "totototo");
	}*/
			
}
