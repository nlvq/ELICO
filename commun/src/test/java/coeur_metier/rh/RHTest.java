package coeur_metier.rh;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import coeur_metier.authentification.AuthentificationImpl;
import coeur_metier.authentification.SimulateUtilisateurDAO;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

public class RHTest {
	private RH rh;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
				
	}

	
	@Test
	public void testCreateOrga() {
	}

	@Test
	public void testDeleteOrga() {
		
	}

	@Test
	public void testFindOrga() {
		
	}

	@Test
	public void testCreateUser() {
		
SimulateUtilisateurDAO utilisateurDAO = new SimulateUtilisateurDAO();
		
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("u1");
		u1.setPassword("pwd");
		utilisateurDAO.createUtilisateur(u1);
		assertEquals(utilisateurDAO.findAll().size(), 1);
		assertEquals(utilisateurDAO.findAll().get(0).getLogin(),"u1");
		}

	@Test
	public void testDeleteUser() {
		SimulateUtilisateurDAO utilisateurDAO = new SimulateUtilisateurDAO();
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("u1");
		u1.setPassword("pwd");
		utilisateurDAO.createUtilisateur(u1);
		assertEquals(utilisateurDAO.findAll().size(), 1);
		utilisateurDAO.deleteUtilisateur(u1);
		assertEquals(utilisateurDAO.findAll().size(), 0);
			
	}

	@Test
	public void testSetRoles() {
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
		
		utilisateurDAO.createUtilisateur(u1);
		
		List<Utilisateur> list = utilisateurDAO.findUtilisateur(u1);
		assertEquals(list.get(0).getAppartient().get(0), "admin");
			
				
	}

	@Test
	public void testFindUser() {
		SimulateUtilisateurDAO utilisateurDAO = new SimulateUtilisateurDAO();
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("u1");
		u1.setPassword("pwd");
		utilisateurDAO.createUtilisateur(u1);
		assertEquals(utilisateurDAO.findAll().get(0).getLogin(),"u1");
		
	}

	@Test
	public void testResetPassword() {
		SimulateUtilisateurDAO utilisateurDAO = new SimulateUtilisateurDAO();
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("u1");
		u1.setPassword("pwd");
		utilisateurDAO.createUtilisateur(u1);
		utilisateurDAO.findAll().get(0).setPassword("password");
		assertEquals(utilisateurDAO.findAll().get(0).getPassword(),"password");
		
		
	}

}
