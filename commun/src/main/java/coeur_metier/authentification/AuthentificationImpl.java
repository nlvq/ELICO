package coeur_metier.authentification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IUtilisateurDAO;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

@Transactional
@Service("authentificationImpl")
public class AuthentificationImpl implements IAuthentification {

	@Autowired
	private IUtilisateurDAO utilisateurDAO;

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

	@Override
	public List<Role> auth(String login, String password) {
		// Try to find user:
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setLogin(login);
		utilisateur.setPassword(password);
		List<Utilisateur> list = utilisateurDAO.findUtilisateur(utilisateur);
		// Test if only one is found:
		if(list.size() != 1){
			return null;
		}
		// Retrieve roles:
		ArrayList<Role> roles = new ArrayList<Role>();
		for(UtilisateurOrganisationRole uor : list.get(0).getAppartient()){
			Role r = uor.getRole();
			if(!roles.contains(r)){
				roles.add(r);
			}
		}
		return roles;
	}

}
