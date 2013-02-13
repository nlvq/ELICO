package coeur_metier.authentification;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

public class TestAuthentification {
	
	private AuthentificationImpl authentificationImpl;
	
	@Before
	public void init(){
		authentificationImpl = new AuthentificationImpl();
		
		SimulateUtilisateurDAO utilisateurDAO = new SimulateUtilisateurDAO();
		
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("u1");
		u1.setPassword("pwd");
		ArrayList<UtilisateurOrganisationRole> appartient = new ArrayList<UtilisateurOrganisationRole>();
		UtilisateurOrganisationRole uor1 = new UtilisateurOrganisationRole();
		Role role1 = new Role();
		role1.setTitle("admin");
		uor1.setRole(role1);
		appartient.add(uor1);
		UtilisateurOrganisationRole uor2 = new UtilisateurOrganisationRole();
		Role role2 = new Role();
		role2.setTitle("reader");
		uor2.setRole(role2);
		appartient.add(uor2);
		u1.setAppartient(appartient);
		utilisateurDAO.createUtilisateur(u1);
		
		Utilisateur u2 = new Utilisateur();
		u2.setLogin("u2");
		u2.setPassword("pwd");
		utilisateurDAO.createUtilisateur(u2);
		
		authentificationImpl.setUtilisateurDAO(utilisateurDAO);
	}
	
	@Test
	public void testAuthentification(){
		// ok
		Assert.assertNotNull(authentificationImpl.auth("u1", "pwd"));
		// wrong password
		Assert.assertNull(authentificationImpl.auth("u1", "wrongpwd"));
		// unknown user
		Assert.assertNull(authentificationImpl.auth("dontexist", "pwd"));
	}
	
	@Test
	public void testRole(){
		List<Role> list = authentificationImpl.auth("u1", "pwd");
		Assert.assertEquals(list.get(0).getTitle(), "admin");
		Assert.assertEquals(list.get(1).getTitle(), "reader");
	}
	
}
