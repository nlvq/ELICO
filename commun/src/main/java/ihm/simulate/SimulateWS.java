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

    public static SimulateWS getRoot() {
        List<SimulateObjet> objets = new ArrayList<>();
        objets.add(new SimulateObjet("File1"));
        objets.add(new SimulateObjet("File2"));

        List<SimulateWP> wps = new ArrayList<>();
        wps.add(new SimulateWP(SimulateDroit.LDroit.WRITE, objets, "WP1"));

        List<SimulateWS> list = new ArrayList<>();
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
