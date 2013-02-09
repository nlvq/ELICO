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
}
