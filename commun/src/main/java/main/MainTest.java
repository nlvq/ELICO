package main;

import static org.junit.Assert.*;

import ihm.AddUserWindow;
import ihm.AdminWindow;
import ihm.AuthentificationLoginWindow;
import ihm.IWindow;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import coeur_metier.rh.RH;
import dao.Role;
import dao.UtilisateurOrganisationRole;

public class MainTest {


	@Before
	public  void setUpBeforeClass() throws Exception {

		ContextUtil.createContext();
		
		RH rh = ContextUtil.getRH();
		rh.createOrga("elico", "enterprise", null);
		rh.createUser("admin", "firstname", "lastname", "0123456789", "elico", "admin");
		ArrayList<UtilisateurOrganisationRole> appartient = new ArrayList<UtilisateurOrganisationRole>();
		UtilisateurOrganisationRole uor1 = new UtilisateurOrganisationRole();
		Role role1 = new Role();
		role1.setTitle("admin");
		uor1.setRole(role1);
		uor1.setOrganisation(rh.findOrga("elico").get(0));
		uor1.setUtilisateur(rh.findUser("admin").get(0));
		appartient.add(uor1);
		UtilisateurOrganisationRole uor2 = new UtilisateurOrganisationRole();
		Role role2 = new Role();
		role2.setTitle("supervisor");
		uor2.setRole(role2);
		uor2.setOrganisation(rh.findOrga("elico").get(0));
		uor2.setUtilisateur(rh.findUser("admin").get(0));
		appartient.add(uor2);
		UtilisateurOrganisationRole uor3 = new UtilisateurOrganisationRole();
		Role role3 = new Role();
		role3.setTitle("validator");
		uor3.setRole(role3);
		uor3.setOrganisation(rh.findOrga("elico").get(0));
		uor3.setUtilisateur(rh.findUser("admin").get(0));
		appartient.add(uor3);
		rh.setRoles("admin", appartient);
	}

	@Test
	public void testLogin() throws IOException {

		IWindow window = new AuthentificationLoginWindow();
		window.createWindow();
		window.openWindow();
		System.in.read();
	}


	@Test
	public void testAdmin() throws IOException {
		IWindow window = new AdminWindow();
		window.createWindow();
		window.openWindow();
		System.in.read();
	}


	@Test
	public void testAjoutAdmin() throws IOException {
		IWindow window = new AddUserWindow();
		window.createWindow();
		window.openWindow();
		System.in.read();
	}

}
