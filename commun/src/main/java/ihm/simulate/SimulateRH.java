package ihm.simulate;

import java.util.ArrayList;
import java.util.List;

public class SimulateRH {
    public List<SimulateUser> getAllUsers() {
        ArrayList<SimulateUser> users = new ArrayList<SimulateUser>();
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));
        users.add(new SimulateUser("Toto", "Titi", "ttoto", "****", "0606060606"));
        users.add(new SimulateUser("Foo", "Bar", "fbar", "****", "0606060606"));


        return users;
    }

    public void createNewUser(String firstName, String lastName, String login, String password, String phoneNumber) {
        System.out.println("Création de l'utilisateur ("+ firstName +
                ", " + lastName + ", " + login + ", " + password +
                ", " + phoneNumber + ")");
    }

    public List<SimulateOrg> getUserOrgs(SimulateUser user) {

        return null;
    }
}
