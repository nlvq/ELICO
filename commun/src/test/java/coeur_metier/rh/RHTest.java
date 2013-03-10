package coeur_metier.rh;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.Organisation;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

public class RHTest {

	private RH rh;

	@Before
	public void init() {
		rh = new RH();
		SimulateOrganisationDAO organisationDAO = new SimulateOrganisationDAO();
		rh.setOrganisationDAO(organisationDAO);
		SimulateUserDAO utilisateurDAO = new SimulateUserDAO();
		rh.setUtilisateurDAO(utilisateurDAO);
	}

	@Test
	public void testCreateOrga() {
		Organisation parent = new Organisation();
		parent.setTitle("orga2");
		parent.setType("enterprise");
		rh.createOrga("orga1", "departement", parent);
		List<Organisation> list = rh.findOrga("orga1");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getTitle(), "orga1");
		assertEquals(list.get(0).getType(), "departement");
		assertEquals(list.get(0).getParent().getTitle(), "orga2");
		assertEquals(list.get(0).getParent().getType(), "enterprise");
	}

	@Test
	public void testUpdateOrga() {
		rh.createOrga("orga20", "departement", null);
		Organisation o = rh.findOrga("orga20").get(0);
		o.setType("team");
		rh.updateOrga(o);
		o = rh.findOrga("orga20").get(0);
		assertEquals(o.getType(), "team");
	}

	@Test
	public void testDeleteOrga() {
		rh.createOrga("orga3", "departement", null);
		rh.deleteOrga("orga3");
		List<Organisation> list = rh.findOrga("orga3");
		assertEquals(list.size(), 0);
	}

	@Test
	public void testFindOrga() {
		rh.createOrga("orga4", "departement", null);
		List<Organisation> list = rh.findOrga("orga4");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getTitle(), "orga4");
		assertEquals(list.get(0).getType(), "departement");
	}

	@Test
	public void testCreateUser() {
		rh.createOrga("orga5", "departement", null);
		rh.createUser("u1", "firstname", "lastname", "0123456789", "orga5", "pwd");
		List<Utilisateur> list = rh.findUser("u1");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getLogin(), "u1");
		assertEquals(list.get(0).getFirstName(), "firstname");
		assertEquals(list.get(0).getLastName(), "lastname");
		assertEquals(list.get(0).getPhoneNumber(), "0123456789");
		assertEquals(list.get(0).getAppartient().get(0).getOrganisation().getTitle(), "orga5");
		assertEquals(list.get(0).getAppartient().get(0).getOrganisation().getType(), "departement");
	}

	@Test
	public void testCreateUserBis() {
		// The same, but with an organisation that doesnt exist
		rh.createUser("u2", "firstname", "lastname", "0123456789", "orga6", "pwd");
		List<Utilisateur> list = rh.findUser("u2");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getLogin(), "u2");
		assertEquals(list.get(0).getFirstName(), "firstname");
		assertEquals(list.get(0).getLastName(), "lastname");
		assertEquals(list.get(0).getPhoneNumber(), "0123456789");
		assertEquals(list.get(0).getAppartient().get(0).getOrganisation().getTitle(), "orga6");
		assertEquals(list.get(0).getAppartient().get(0).getOrganisation().getType(), "default");
	}

	@Test
	public void testDeleteUser() {
		rh.createUser("u3", "firstname", "lastname", "0123456789", "orga7", "pwd");
		rh.deleteUser("u3");
		List<Utilisateur> list = rh.findUser("u3");
		assertEquals(list.size(), 0);
	}

	@Test
	public void testUpdateUser() {
		rh.createUser("u4", "firstname", "lastname", "0123456789", "orga8", "pwd");
		Utilisateur u = rh.findUser("u4").get(0);
		u.setPassword("mypassword");
		rh.updateUser(u);
		u = rh.findUser("u4").get(0);
		assertEquals(u.getPassword(), "mypassword");
	}

	@Test
	public void testSetRoles() {
		rh.createUser("u5", "firstname", "lastname", "0123456789", "orga9", "pwd");
		ArrayList<UtilisateurOrganisationRole> appartient = new ArrayList<UtilisateurOrganisationRole>();
		UtilisateurOrganisationRole uor1 = new UtilisateurOrganisationRole();
		Role role1 = new Role();
		role1.setTitle("admin");
		uor1.setRole(role1);
		uor1.setOrganisation(rh.findOrga("orga9").get(0));
		uor1.setUtilisateur(rh.findUser("u5").get(0));
		appartient.add(uor1);
		UtilisateurOrganisationRole uor2 = new UtilisateurOrganisationRole();
		Role role2 = new Role();
		role2.setTitle("engineer");
		uor2.setRole(role2);
		uor2.setOrganisation(rh.findOrga("orga9").get(0));
		uor2.setUtilisateur(rh.findUser("u5").get(0));
		appartient.add(uor2);
		rh.setRoles("u5", appartient);
		List<Utilisateur> list = rh.findUser("u5");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getLogin(), "u5");
		assertEquals(list.get(0).getAppartient().get(0).getRole().getTitle(), "admin");
		assertEquals(list.get(0).getAppartient().get(0).getOrganisation().getTitle(), "orga9");
		assertEquals(list.get(0).getAppartient().get(1).getRole().getTitle(), "engineer");
		assertEquals(list.get(0).getAppartient().get(1).getOrganisation().getTitle(), "orga9");
	}

	@Test
	public void testFindUser() {
		rh.createUser("u6", "firstname", "lastname", "0123456789", "orga10", "pwd");
		List<Utilisateur> list = rh.findUser("u6");
		assertEquals(list.size(), 1);
		assertEquals(list.get(0).getLogin(), "u6");
		assertEquals(list.get(0).getFirstName(), "firstname");
		assertEquals(list.get(0).getLastName(), "lastname");
		assertEquals(list.get(0).getPhoneNumber(), "0123456789");
		assertEquals(list.get(0).getAppartient().get(0).getOrganisation().getTitle(), "orga10");
		assertEquals(list.get(0).getAppartient().get(0).getOrganisation().getType(), "default");
	}

	@Test
	public void testResetPassword() {
		rh.createUser("u7", "firstname", "lastname", "0123456789", "orga11", "pwd");
		Utilisateur u = rh.findUser("u7").get(0);
		u.setPassword("mypassword");
		rh.updateUser(u);
		rh.resetPassword("u7");
		u = rh.findUser("u7").get(0);
		assertEquals(u.getPassword(), "pwd");
	}

}
