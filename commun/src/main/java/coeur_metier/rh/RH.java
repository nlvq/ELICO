package coeur_metier.rh;

import java.util.ArrayList;
import java.util.List;

import dao.IObjetDAO;
import dao.IOrganisationDAO;
import dao.IUtilisateurDAO;
import dao.Objet;
import dao.Organisation;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;
import dao.impl.DefaultOrganisationDAO;
import dao.impl.DefaultUtilisateurDAO;

public class RH implements IRH {
     private Organisation orga;
	 private IUtilisateurDAO daousr;
	 private IOrganisationDAO dao ;
	 private Utilisateur usr;

	 public RH(IUtilisateurDAO dao) {
			super();
			this.daousr = dao;
		}
	@Override
	public void createOrga(String name, String type, Organisation parentOrga) {
		orga=new Organisation();
		orga.setTitle(name);
		orga.setType(type);
		orga.setParent(parentOrga);
		dao.createOrganisation(orga);
	
		
	}

	@Override
	public void deleteOrga(String name) {
		orga.setTitle(name);
		if (dao.findOrganisation(orga)!=null) dao.deleteOrganisation(dao.findOrganisation(orga).get(0));
		
	}

	@Override
	public List<Organisation> findOrga(String Orga) {
		orga.setTitle(Orga);
		if (dao.findOrganisation(orga)!=null) System.out.print("Message d'erreur :organisation inexistante");

		return dao.findOrganisation(orga) ;
	}

	@Override
	public void createUser(String firstname, String lastname,
			String phonenumber, String nameOrga) {
		usr=new Utilisateur();
		usr.setFirstName(firstname);
		usr.setLastName(lastname);
		usr.setPhoneNumber(phonenumber);
		usr.setLogin("usr");
		usr.setPassword("pwd");
		//orga.setTitle("orga");
		usr.setAppartient(null);
		usr.setSavoirfaires(null);
		usr.setWorkspaces(null);
		//usr.setAppartient();// je ne sais pas comment faire la relation ternaire!!!
		daousr.createUtilisateur(usr);
		
	}

	@Override
	public void deleteUser(String loginUser) {
		usr.setLogin(loginUser);
		if (daousr.findUtilisateur(usr)!=null) 
			daousr.deleteUtilisateur(daousr.findUtilisateur(usr).get(0));
		else System.out.print("User inexistant ou login incorrect!!!");
		
	}

	@Override
	public void setRoles(String loginUser, List<Role> role) {
		usr.setLogin(loginUser);
		for(Role r : role){		daousr.findUtilisateur(usr).get(0).
			setSavoirfaires(r.getSavoirfaires());
		}
		
	}

	@Override
	public Utilisateur findUser(String loginUser) {
		usr.setLogin(loginUser);
		if (daousr.findUtilisateur(usr)!=null) return(daousr.findUtilisateur(usr).get(0));
		else { System.out.print("User inexistant ou login incorrect!!!");
		        return(null);}
	}

	@Override
	public void resetPassword(String loginUsern) {
		usr.setLogin(loginUsern);
		if (daousr.findUtilisateur(usr)!=null) daousr.findUtilisateur(usr).get(0).setPassword("password");
		else System.out.print("User inexistant ou login incorrect!!!");
		
	}

	
}
