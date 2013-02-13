package coeur_metier.authentification;

import java.util.List;

import dao.Role;

public interface IAuthentification {

	/**
	 * Authentifie l'utilisateur : si le login existe et que le password est bon, retourne ses roles, sinon null.
	 * 
	 * @param login
	 * @param password
	 * @return
	 */
	List<Role> auth(String login, String password);

}
