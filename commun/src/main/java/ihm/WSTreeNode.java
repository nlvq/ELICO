package ihm;

import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import dao.Utilisateur;
import dao.WorkPackage;
import dao.WorkSpace;

public class WSTreeNode implements TreeModel {
		private final Utilisateur user;
	  public WSTreeNode(Utilisateur user) {
	  	this.user = user;
    }
	  
    @Override
    public Object getRoot() {
    	  List<WorkSpace> workspaces = user.getWorkspaces();
    	  if (workspaces.size() == 0) {
    	  	return null;
    	  }
				return workspaces.get(0);
    }

    Object recGetChild(WorkSpace ws, Object parent, int index) {
        if (ws.equals(parent)) {
            if (index < ws.getChilds().size()) {
                return ws.getChilds().get(index);
            } else {
                index -= ws.getChilds().size();
                return ws.getWorkpackages().get(index);
            }
        }
        for (WorkSpace simulateWS : ws.getChilds()) {
            Object ret = recGetChild(simulateWS, parent, index);
            if (ret != null) {
                return ret;
            }
        }
        for (WorkPackage simulateWP: ws.getWorkpackages()) {
            if (simulateWP.equals(parent)) {
                return simulateWP.getObjets().get(index);
            }
        }
        return null;
    }

    @Override
    public Object getChild(Object parent, int index) {
        WorkSpace root = user.getWorkspaces().get(0);
        return recGetChild(root, parent, index);
    }

    int recCountChild(WorkSpace ws, Object parent) {
        if (ws.equals(parent)) {
            return ws.getChilds().size() + ws.getWorkpackages().size();
        }
        for (WorkSpace simulateWS : ws.getChilds()) {
            int ret = recCountChild(simulateWS, parent);
            if (ret != -1) {
                return ret;
            }
        }
        for (WorkPackage simulateWP: ws.getWorkpackages()) {
            if (simulateWP.equals(parent)) {
                return simulateWP.getObjets().size();
            }
        }
        return -1;
    }

    @Override
    public int getChildCount(Object parent) {
        return recCountChild(user.getWorkspaces().get(0), parent);
    }

    @Override
    public boolean isLeaf(Object node) {
        if (node instanceof WorkPackage) {
            return true;
        }
        return false;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    int recFindChild(WorkSpace ws, Object parent, Object child) {
        if (ws.equals(parent)) {
            for (int i = 0; i < ws.getChilds().size(); i++) {
                if (ws.getChilds().get(i).equals(child)) {
                    return i;
                }
            }
        }
        for (WorkSpace simulateWS : ws.getChilds()) {
            int ret = recFindChild(simulateWS, parent, child);
            if (ret != -1) {
                return ret;
            }
        }
        for (WorkPackage simulateWP: ws.getWorkpackages()) {
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
        return recFindChild(user.getWorkspaces().get(0), parent, child);
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
