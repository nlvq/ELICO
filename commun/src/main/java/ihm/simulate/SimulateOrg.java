package ihm.simulate;

import java.util.ArrayList;
import java.util.List;

public class SimulateOrg {
	private String title;
    private SimulateOrg parent;
    private SimulateWS ws;
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

    public List<SimulateOrg> getChilds() {
        return childs;
    }

    public static void addOrg(SimulateOrg parent, String name, SimulateUser user) {
        System.out.println("Add Org in " + parent + " name: " + name + " User: " + user);
    }

    @Override
    public String toString() {
        return title;
    }

    public SimulateWS getWS() {
        return ws;
    }

    public List<SimulateWP> getWPs() {
        ArrayList<SimulateWP> wps = new ArrayList<>();
        wps.add(new SimulateWP(SimulateDroit.LDroit.READ, new ArrayList<SimulateObjet>(), "WP1", null));
        return wps;
    }

    public void addWS(SimulateWS ws) {
        workspaces.add(ws);
    }
}
