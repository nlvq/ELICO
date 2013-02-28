package coeur_metier.rh;

import java.util.List;

import dao.Organisation;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

public interface IRH {
	public void createOrga(String name, String type, Organisation parentOrga);
	public void deleteOrga(String name);
	public void updateOrga(Organisation orga);
	public List<Organisation> findOrga(String nameOrga);
	public void createUser(String login, String firstname, String lastname, String phonenumber, String nameOrga);
	public void deleteUser(String loginUser);
	public void updateUser(Utilisateur user);
	public void setRoles(String loginUser, List<UtilisateurOrganisationRole> uor);
	public List<Utilisateur> findUser(String loginUser);
	public void resetPassword(String loginUser);
}
