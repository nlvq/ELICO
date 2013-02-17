package ihm.simulate;


import java.util.ArrayList;
import java.util.List;

public class SimulateWP {
    private String title;
    private SimulateDroit.LDroit droit;
    private List<SimulateObjet> objects = new ArrayList<>();
    private SimulateWS parentWS;

    public SimulateWP(SimulateDroit.LDroit droit, List<SimulateObjet> objets, String title, SimulateWS parentWS) {
        this.droit = droit;
        this.objects = objets;
        this.title = title;
        this.parentWS = parentWS;
    }

    public void setObjects(List<SimulateObjet> objects) {
        this.objects = objects;
    }

    public List<SimulateObjet> getObjects() {
        return objects;
    }

    public SimulateWS getParentWS() {
        return parentWS;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimulateWP that = (SimulateWP) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}
