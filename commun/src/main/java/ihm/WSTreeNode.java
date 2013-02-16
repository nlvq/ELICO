package ihm;

import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class WSTreeNode implements TreeModel {
    @Override
    public Object getRoot() {
        return SimulateWS.getRoot();
    }

    Object recGetChild(SimulateWS ws, Object parent, int index) {
        if (ws.equals(parent)) {
            if (index < ws.getChilds().size()) {
                return ws.getChilds().get(index);
            } else {
                index -= ws.getChilds().size();
                return ws.getWorkpackages().get(index);
            }
        }
        for (SimulateWS simulateWS : ws.getChilds()) {
            Object ret = recGetChild(simulateWS, parent, index);
            if (ret != null) {
                return ret;
            }
        }
        for (SimulateWP simulateWP: ws.getWorkpackages()) {
            if (simulateWP.equals(parent)) {
                return simulateWP.getObjets().get(index);
            }
        }
        return null;
    }

    @Override
    public Object getChild(Object parent, int index) {
        SimulateWS root = SimulateWS.getRoot();
        return recGetChild(root, parent, index);
    }

    int recCountChild(SimulateWS ws, Object parent) {
        if (ws.equals(parent)) {
            return ws.getChilds().size() + ws.getWorkpackages().size();
        }
        for (SimulateWS simulateWS : ws.getChilds()) {
            int ret = recCountChild(simulateWS, parent);
            if (ret != -1) {
                return ret;
            }
        }
        for (SimulateWP simulateWP: ws.getWorkpackages()) {
            if (simulateWP.equals(parent)) {
                return simulateWP.getObjets().size();
            }
        }
        return -1;
    }

    @Override
    public int getChildCount(Object parent) {
        return recCountChild(SimulateWS.getRoot(), parent);
    }

    @Override
    public boolean isLeaf(Object node) {
        if (node instanceof SimulateWP) {
            return true;
        }
        return false;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    int recFindChild(SimulateWS ws, Object parent, Object child) {
        if (ws.equals(parent)) {
            for (int i = 0; i < ws.getChilds().size(); i++) {
                if (ws.getChilds().get(i).equals(child)) {
                    return i;
                }
            }
        }
        for (SimulateWS simulateWS : ws.getChilds()) {
            int ret = recFindChild(simulateWS, parent, child);
            if (ret != -1) {
                return ret;
            }
        }
        for (SimulateWP simulateWP: ws.getWorkpackages()) {
            if (simulateWP.equals(parent)) {
                for (int i = 0; i < simulateWP.getObjets().size(); i++) {
                    if (simulateWP.getObjets().get(i).equals(child)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return recFindChild(SimulateWS.getRoot(), parent, child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        ;
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        ;
    }
}
