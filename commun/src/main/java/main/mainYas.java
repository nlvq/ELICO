package main;

import java.util.ArrayList;
import java.util.List;

import coeur_metier.livre.Livre;
import coeur_metier.rh.RH;
import coeur_metier.wp.WorkPackageImpl;
import dao.Objet;
import dao.Role;
import dao.UtilisateurOrganisationRole;
import dao.WorkPackage;
import ihm.AuthentificationLoginWindow;
import ihm.IWindow;
import ihm.ValidatorWindow;

public class mainYas {
	
	/**
	 * Create admin user.
	 *   Login = admin
	 *   Password = admin
	 *   Roles : admin, supervisor, validator
	 */
	private static void createAdminUser() {
		WorkPackageImpl wp=ContextUtil.getWorkPackage();
		ArrayList<Objet> listObjet = new ArrayList<Objet>();
		Objet o1 = new Objet();
		o1.setContent("a a a");
		listObjet.add(o1);
		Objet o2 = new Objet();
		o2.setContent("b b b");
		listObjet.add(o2);
		wp.createWP("wp1", listObjet);
		/*RH rh = ContextUtil.getRH();
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
*/	}

	/**
	 * Main method : init and open authentification window.
	 * @param args
	 */
	public static void main(String[] args) {
		ContextUtil.createContext();
		createAdminUser();
		IWindow window = new ValidatorWindow();
		window.createWindow();
		window.openWindow();
	}
}
