package ihm.simulate;

import java.util.ArrayList;
import java.util.List;

import coeur_metier.authentification.IAuthentification;
import dao.Role;

public class SimulateAuthentification implements IAuthentification {

	@Override
	public List<Role> auth(String login, String password) {
		if(login.equals("toto") && password.equals("pwd")){
			ArrayList<Role> roles = new ArrayList<Role>();
			Role role1 = new Role();
			role1.setTitle("admin");
			roles.add(role1);
			Role role2 = new Role();
			role2.setTitle("supervisor");
			roles.add(role2);
			return roles;
		}
		else{
			return null;
		}
	}

}
