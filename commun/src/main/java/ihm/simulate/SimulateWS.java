package ihm.simulate;


import java.util.ArrayList;
import java.util.List;

public class SimulateWS {
    private String title;
    private SimulateWS parent;
    private List<SimulateWS> childs = new ArrayList<>();
    private SimulateOrg organisation;
    private List<SimulateWP> workpackages = new ArrayList<>();

    public SimulateWS(List<SimulateWS> childs, SimulateOrg organisation, SimulateWS parent, String title, List<SimulateWP> workpackages) {
        this.childs = childs;
        this.organisation = organisation;
        this.parent = parent;
        this.title = title;
        this.workpackages = workpackages;
    }

    public List<SimulateWS> getChilds() {
        return childs;
    }

    public List<SimulateWP> getWorkpackages() {
        return workpackages;
    }

    public void setWorkpackages(List<SimulateWP> workpackages) {
        this.workpackages = workpackages;
    }

    public SimulateOrg getOrg() {
        return organisation;
    }

    private static List<SimulateObjet> createObjects(SimulateWP parent, int size) {
        List<SimulateObjet> objets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            objets.add(new SimulateObjet("File" + i, parent));
        }
        return objets;
    }

    private static List<SimulateWP> createWPs(SimulateWS parent, int size) {
        List<SimulateWP> wps = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int nbWP = (int) (1 + (Math.random() * 100) % 20);
            SimulateWP wp = new SimulateWP(SimulateDroit.LDroit.WRITE, null, "WP" + i, parent);
            wp.setObjects(createObjects(wp, nbWP));
            wp.addUser(new SimulateUser("Toto", "Bar", "Log", "pwd", "06"), null);
            wps.add(wp);
        }
        return wps;
    }

    public static SimulateWS getRoot() {
        SimulateWS ws = new SimulateWS(new ArrayList<SimulateWS>(),
                new SimulateOrg(null, null, "Org1", null),
                null,
                "WS1",
                null);
        List<SimulateWP> wps = createWPs(ws, 5);
        ws.setWorkpackages(wps);
        return ws;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimulateWS that = (SimulateWS) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    public void addWP(String name, List<SimulateObjet> objects) {
        SimulateWP simulateWP = new SimulateWP(SimulateDroit.LDroit.READ, objects, name, this);

        for (SimulateObjet object: objects) {
            object.setParent(simulateWP);
        }

        System.out.println("Add WP: Name: " + simulateWP.getTitle() + " objects: " + simulateWP.getObjects());

        workpackages.add(simulateWP);
    }

    public void removeWP(SimulateWP wp) {
        System.out.println("Suppression de " + wp);
        workpackages.remove(wp);
    }
}
