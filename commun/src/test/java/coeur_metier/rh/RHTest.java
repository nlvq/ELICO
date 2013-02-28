package coeur_metier.rh;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import dao.IUtilisateurDAO;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

public class RHTest {
	

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

	
	
	private IUtilisateurDAO dao = new SimulateRHDAO();
	private IRH rh = new RH(dao);

	
	
	@Test
	public void testCreateUser() {		
		
		rh.createUser("u1","l1", "12", "jjj");
		List<Utilisateur> list = dao.findAll();
		Utilisateur o = list.get(0);
		assertEquals((String)o.getFirstName(), (String)"u1");
		
		
		}

	@Test
	public void testDeleteUser() {
		
		Utilisateur u1 = new Utilisateur();
		u1.setLogin("u1");
		u1.setPassword("pwd");
		rh.createUser("u1","l1", "12", "jjj");
		assertEquals(dao.findAll().size(), 1);
		rh.deleteUser("u1");
		
		assertEquals(dao.findAll().size(),0);
			
	}

	@Test
	public void testSetRoles() {
		rh.createUser("u1","l1", "12", "jjj");
		
		Utilisateur u1 = new Utilisateur();
		u1=dao.findAll().get(0);
		u1.setLogin("u1");
		u1.setPassword("pwd");
		
		ArrayList<UtilisateurOrganisationRole> appartient = new ArrayList<UtilisateurOrganisationRole>();
		UtilisateurOrganisationRole uor1 = new UtilisateurOrganisationRole();
		Role role1 = new Role();
		role1.setTitle("admin");
		uor1.setRole(role1);
		appartient.add(uor1);
		
		dao.findAll().get(0).setAppartient(appartient);
		
		Utilisateur user = dao.findAll().get(0);
		assertEquals(user.getAppartient().get(0).getRole().getTitle(), "admin");
			
				
	}

	@Test
	public void testFindUser() {
		rh.createUser("u1","l1", "12", "jjj");
		List<Utilisateur> list = dao.findAll();
		Utilisateur o = list.get(0);
		assertEquals((String)o.getFirstName(), (String)"u1");
		rh.findUser("usr");
		assertEquals((rh.findUser("usr")).getFirstName(),"u1");
		assertEquals((rh.findUser("usr")).getLastName(),"l1");
		
	}

	@Test
	public void testResetPassword() {
		rh.createUser("u1","l1", "12", "jjj");
		List<Utilisateur> list = dao.findAll();
		Utilisateur o = list.get(0);
		list.get(0).setPassword("password");
		assertEquals((String)o.getFirstName(), (String)"u1");
		assertEquals(dao.findAll().get(0).getPassword(),"password");
		
	}

}
