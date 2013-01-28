package coeur_metier.rh;

import java.util.List;

import dao.Organisation;
import dao.Role;
import dao.Utilisateur;

public class RH implements IRH {

	@Override
	public void createOrga(String name, String type, Organisation parentOrga) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrga(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Organisation> findOrga(String Orga) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(String user, String nameOrga) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String loginUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRoles(String loginUser, List<Role> role) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utilisateur> findUser(String loginUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetPassword(String loginUsern) {
		// TODO Auto-generated method stub

	}

}
