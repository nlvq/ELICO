package coeur_metier.rh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IOrganisationDAO;
import dao.IUtilisateurDAO;
import dao.IUtilisateurOrganisationRoleDAO;
import dao.Organisation;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

@Transactional
@Service("rh")
public class RH implements IRH {

	@Autowired
	private IUtilisateurDAO utilisateurDAO;

	@Autowired
	private IOrganisationDAO organisationDAO;

	@Autowired
	private IUtilisateurOrganisationRoleDAO uorDAO;

	/**
	 * @return the utilisateurDAO
	 */
	public IUtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	/**
	 * @param utilisateurDAO the utilisateurDAO to set
	 */
	public void setUtilisateurDAO(IUtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	/**
	 * @return the organisationDAO
	 */
	public IOrganisationDAO getOrganisationDAO() {
		return organisationDAO;
	}

	/**
	 * @param organisationDAO the organisationDAO to set
	 */
	public void setOrganisationDAO(IOrganisationDAO organisationDAO) {
		this.organisationDAO = organisationDAO;
	}

	@Override
	public void createOrga(String name, String type, Organisation parentOrga) {
		Organisation orga = new Organisation();
		orga.setTitle(name);
		orga.setType(type);
		orga.setParent(parentOrga);
		organisationDAO.createOrganisation(orga);
	}

	@Override
	public void deleteOrga(String name) {
		Organisation orga = new Organisation();
		orga.setTitle(name);
		List<Organisation> list = organisationDAO.findOrganisation(orga);
		if (list != null && !list.isEmpty())
			organisationDAO.deleteOrganisation(list.get(0));
	}

	@Override
	public void updateOrga(Organisation orga) {
		organisationDAO.updateOrganisation(orga);
	}

	@Override
	public List<Organisation> findOrga(String nameOrga) {
		Organisation orga = new Organisation();
		orga.setTitle(nameOrga);
		return organisationDAO.findOrganisation(orga);
	}

	@Override
	public void createUser(String login, String firstname, String lastname,
			String phonenumber, String nameOrga, String password) {
		Utilisateur usr = new Utilisateur();
		usr.setLogin(login);
		usr.setFirstName(firstname);
		usr.setLastName(lastname);
		usr.setPhoneNumber(phonenumber);
		usr.setPassword(password);
		ArrayList<UtilisateurOrganisationRole> listuor = new ArrayList<UtilisateurOrganisationRole>();
		UtilisateurOrganisationRole uor = new UtilisateurOrganisationRole();
		List<Organisation> list = findOrga(nameOrga);
		if(list == null || list.isEmpty()){
			createOrga(nameOrga, "default", null);
			list = findOrga(nameOrga);
		}
		uor.setOrganisation(list.get(0));
		Role r = new Role();
		r.setTitle("reader");
		uor.setRole(r);
		uor.setUtilisateur(usr);
		listuor.add(uor);
		usr.setAppartient(listuor);
		utilisateurDAO.createUtilisateur(usr);
	}

	@Override
	public void deleteUser(String loginUser) {
		Utilisateur usr = new Utilisateur();
		usr.setLogin(loginUser);
		List<Utilisateur> found = utilisateurDAO.findUtilisateur(usr);
		if (found != null && !found.isEmpty()) {
			utilisateurDAO.deleteUtilisateur(found.get(0));
		}
	}

	@Override
	public void updateUser(Utilisateur user) {
		utilisateurDAO.updateUtilisateur(user);
	}

	@Override
	public void setRoles(String loginUser, List<UtilisateurOrganisationRole> uor) {
		Utilisateur usr = new Utilisateur();
		usr.setLogin(loginUser);
		List<Utilisateur> found = utilisateurDAO.findUtilisateur(usr);
		if (found != null && !found.isEmpty()) {
			if(uorDAO != null){
				for(UtilisateurOrganisationRole u : uor){
					Organisation organisation = findOrga(u.getOrganisation().getTitle()).get(0);
					organisation = organisationDAO.merge(organisation);
					organisationDAO.refresh(organisation);
					u.setOrganisation(organisation);
					Utilisateur utilisateur = findUser(u.getUtilisateur().getLogin()).get(0);
					utilisateur = utilisateurDAO.merge(utilisateur);
					utilisateurDAO.refresh(utilisateur);
					u.setUtilisateur(utilisateur);
					uorDAO.createUtilisateurOrganisationRole(u);
				}
			}
			Utilisateur u = found.get(0);
			u.setAppartient(uor);
			utilisateurDAO.updateUtilisateur(u);
		}
	}

	@Override
	public List<Utilisateur> findUser(String loginUser) {
		Utilisateur usr = new Utilisateur();
		usr.setLogin(loginUser);
		return utilisateurDAO.findUtilisateur(usr);
	}

	@Override
	public List<Utilisateur> getAllUser() {
		return utilisateurDAO.findAll();
	}

	@Override
	public void resetPassword(String loginUser) {
		Utilisateur usr = new Utilisateur();
		usr.setLogin(loginUser);
		List<Utilisateur> found = utilisateurDAO.findUtilisateur(usr);
		if (found != null && !found.isEmpty()) {
			Utilisateur u = found.get(0);
			u.setPassword("pwd");
			utilisateurDAO.updateUtilisateur(u);
		}
	}

}
