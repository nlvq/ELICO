package ihm.simulate;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimulateWP {
    private String title;
    private SimulateDroit.LDroit droit;
    private List<SimulateObjet> objects = new ArrayList<>();
    private SimulateWS parentWS;
    private Map<SimulateUser, SimulateJob> users = new HashMap<>();

    public String getTitle() {
        return title;
    }

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

    public void addUser(SimulateUser user, SimulateJob job) {
        System.out.println("Add user : " + user + " with job : " + job);
        users.put(user, job);
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

    public static SimulateObjet[] search(String text) {
        SimulateObjet[] objetsType = new SimulateObjet[1];

        List<SimulateObjet> objects = new ArrayList<>();
        SimulateObjet obj = new SimulateObjet(text, null);
        objects.add(obj);

        SimulateWP wp = new SimulateWP(SimulateDroit.LDroit.WRITE,  objects, "WP", null);

        obj.setParent(wp);

        return wp.getObjects().toArray(objetsType);
    }

    public List<SimulateUser> getUsers() {
        List<SimulateUser> list = new ArrayList<>();
        list.addAll(users.keySet());
        return list;
    }
}
