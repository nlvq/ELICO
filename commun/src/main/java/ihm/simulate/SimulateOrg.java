package ihm.simulate;

import java.util.ArrayList;
import java.util.List;

public class SimulateOrg {
	private String title;
    private SimulateOrg parent;
    private List<SimulateOrg> childs = new ArrayList<>();
    private List<SimulateWS> workspaces = new ArrayList<>();

    public SimulateOrg(List<SimulateOrg> childs, SimulateOrg parent, String title, List<SimulateWS> workspaces) {
        this.childs = childs;
        this.parent = parent;
        this.title = title;
        this.workspaces = workspaces;
    }

    public static List<SimulateUser> getUsers() {
        List<SimulateUser> users = new ArrayList<>();

        users.add(new SimulateUser("Toto", "Tata", "ttata", "****", "0606060606"));
        users.add(new SimulateUser("Tutu", "Titi", "ttiti", "****", "0606060606"));

        return users;
    }

    public static void addOrg(SimulateOrg parent, String name, SimulateUser user) {
        System.out.println("Add Org in " + parent + " name: " + name + " User: " + user);
    }

    @Override
    public String toString() {
        return title;
    }
}
