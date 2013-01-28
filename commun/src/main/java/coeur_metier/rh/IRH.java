package coeur_metier.rh;

import java.util.List;

import dao.Organisation;
import dao.Role;
import dao.Utilisateur;

public interface IRH {

	public void createOrga(String name, String type, Organisation parentOrga);
	public void deleteOrga(String name);
	public List<Organisation> findOrga(String Orga);
	public void createUser(String user, String nameOrga);
	public void deleteUser(String loginUser) ;
	public void setRoles(String loginUser, List<Role> role);
	public List<Utilisateur> findUser(String loginUser);
	public void resetPassword(String loginUsern);

}
