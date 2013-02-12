package ihm.simulate;


import java.util.ArrayList;
import java.util.List;

import dao.Organisation;

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

    private static List<SimulateObjet> createObjects(int size) {
        List<SimulateObjet> objets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            objets.add(new SimulateObjet("File" + i));
        }
        return objets;
    }

    private static List<SimulateWP> createWPs(int size) {
        List<SimulateWP> wps = new ArrayList<>();
<<<<<<< HEAD
        wps.add(new SimulateWP(SimulateDroit.LDroit.WRITE, objets, "WP1"));
        wps.add(new SimulateWP(SimulateDroit.LDroit.WRITE, objets, "WP2"));
        wps.add(new SimulateWP(SimulateDroit.LDroit.WRITE, objets, "WP3"));
=======
        for (int i = 0; i < size; i++) {
            int nbWP = (int) (1 + (Math.random() * 100) % 20);
            wps.add(new SimulateWP(SimulateDroit.LDroit.WRITE, createObjects(nbWP), "WP" + i));
        }
        return wps;
    }

    public static SimulateWS getRoot() {
        List<SimulateWP> wps = createWPs(5);
>>>>>>> Supervisor + begin organization

        return new SimulateWS(new ArrayList<SimulateWS>(),
                new SimulateOrg(null, null, "Org1", null),
                null,
                "WS1",
                wps);
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
}
