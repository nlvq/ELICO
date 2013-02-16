package ihm.simulate;


import java.util.ArrayList;
import java.util.List;

public class SimulateWP {
    private String title;
    @SuppressWarnings("unused")
	private SimulateDroit.LDroit droit;
    private List<SimulateObjet> objets = new ArrayList<>();

    public SimulateWP(SimulateDroit.LDroit droit, List<SimulateObjet> objets, String title) {
        this.droit = droit;
        this.objets = objets;
        this.title = title;
    }

    public List<SimulateObjet> getObjets() {
        return objets;
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
