package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import coeur_metier.rh.RH;
import coeur_metier.wp.WorkPackageImpl;
import coeur_metier.ws.WorkSpaceImpl;
import dao.Objet;
import dao.Role;
import dao.UtilisateurOrganisationRole;
import dao.WorkPackage;
import dao.WorkSpace;


public class CreateTables {
	
	static ClassPathXmlApplicationContext context;
	
	/**
	 * Create admin user.
	 *   Login = admin
	 *   Password = admin
	 *   Roles : admin, supervisor, validator, engineer
	 */
	private static void createAdminUser(){
		RH rh = (RH) context.getBean("rh");
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
		UtilisateurOrganisationRole uor4 = new UtilisateurOrganisationRole();
		Role role4 = new Role();
		role4.setTitle("engineer");
		uor4.setRole(role4);
		uor4.setOrganisation(rh.findOrga("elico").get(0));
		uor4.setUtilisateur(rh.findUser("admin").get(0));
		appartient.add(uor4);
		rh.setRoles("admin", appartient);
	}

	/**
	 * Create some WS and WP.
	 */
	private static void createSomeWSAndWP() {
		RH rh = (RH) context.getBean("rh");
		WorkPackageImpl wp = (WorkPackageImpl) context.getBean("workPackageImpl");
		WorkSpaceImpl ws = (WorkSpaceImpl) context.getBean("workSpaceImpl");
		
		ArrayList<Objet> listObjet1 = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("a a a");
		listObjet1.add(o1);
		Objet o2 = new Objet();
		o2.setContent("b b b");
		listObjet1.add(o2);
		wp.createWP("wp10", listObjet1);
		
		ArrayList<Objet> listObjet2 = new ArrayList<Objet>();
		Objet o3 = new Objet();
		o3.setContent("ccc");
		listObjet2.add(o3);
		Objet o4 = new Objet();
		o4.setContent("ddd");
		listObjet2.add(o4);
		wp.createWP("wp20", listObjet2);

		WorkPackage wpToFind = new WorkPackage();
		wpToFind.setTitle("wp10");
		List<WorkPackage> wpFound = wp.findWP(wpToFind);
		ws.createWS("ws10", null, "orga1", wpFound);
		WorkSpace tofind = new WorkSpace();
		tofind.setTitle("ws10");
		WorkSpace w = ws.findWS(tofind).get(0);
		w.setUtilisateur(rh.findUser("admin").get(0));
		ws.updateWS(w);

		wpToFind = new WorkPackage();
		wpToFind.setTitle("wp20");
		WorkPackage wpp = wp.findWP(wpToFind).get(0);
		wpp.setWorkSpace(ws.findWS(tofind).get(0));
		wp.updateWP(wpp);
	}

	/**
	 * Main method : create tables, admin user, WS, WP.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Create tables...");
		context = new ClassPathXmlApplicationContext("classpath:spring/elico-create-context.xml");
		context.start();
		createAdminUser();
		createSomeWSAndWP();
		System.out.println("OK");
		context.close();
	}
}
