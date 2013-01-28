package fr.umlv.elico.other;

import java.util.LinkedList;
import java.util.List;

import fr.umlv.elico.user.User;


public class SimulateDAO implements DAO {

    @Override
    public List<User> getUserList() {
        List<User> list = new LinkedList<>();
        list.add(new User(1, "A"));
        list.add(new User(2, "B"));
        list.add(new User(3, "C"));
        return list;
    }
}
