package ihm.simulate;

public class SimulateObjet {
    String name;
    SimulateWP parent;

    public SimulateObjet(String name, SimulateWP parent) {
        this.name = name;
        this.parent = parent;
    }

    public SimulateWP getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return name;
    }
}
