package coeur_metier.authentification;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/elico-persistence-test-context.xml" })
public class IntegrationTestAuthentification {
	
	@Resource(name="authentification")
	private AuthentificationImpl authentificationImpl;
	
	@Before
	public void init(){
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("uu1");
		u1.setPassword("pwd");
		ArrayList<UtilisateurOrganisationRole> appartient = new ArrayList<UtilisateurOrganisationRole>();
		UtilisateurOrganisationRole uor1 = new UtilisateurOrganisationRole();
		Role role1 = new Role();
		role1.setTitle("admin");
		uor1.setRole(role1);
		appartient.add(uor1);
		UtilisateurOrganisationRole uor2 = new UtilisateurOrganisationRole();
		Role role2 = new Role();
		role2.setTitle("readerr");
		uor2.setRole(role2);
		appartient.add(uor2);
		u1.setAppartient(appartient);
		authentificationImpl.getUtilisateurDAO().createUtilisateur(u1);
		
		Utilisateur u2 = new Utilisateur();
		u2.setLogin("uu2");
		u2.setPassword("pwd");
		authentificationImpl.getUtilisateurDAO().createUtilisateur(u2);
	}
	
	@Test
	public void testAuthentification(){
		// ok
		Assert.assertNotNull(authentificationImpl.auth("uu1", "pwd"));
		// wrong password
		Assert.assertNull(authentificationImpl.auth("uu1", "wrongpwd"));
		// unknown user
		Assert.assertNull(authentificationImpl.auth("dontexist", "pwd"));
	}
	
	@Test
	public void testRole(){
		List<Role> list = authentificationImpl.auth("uu1", "pwd");
		Assert.assertEquals(list.get(0).getTitle(), "admin");
		Assert.assertEquals(list.get(1).getTitle(), "readerr");
	}
	
}
