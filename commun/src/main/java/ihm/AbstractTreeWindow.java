package ihm;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import dao.Utilisateur;
import dao.WorkPackage;
import dao.WorkSpace;

/**
 * Abstract class which should be use by all user view.
 * All this view uses two panes and a button line.
 * The left pane is filled with a tree.
 * ..........................
 * That class provide a button panel and two panels to fill.
 */
public abstract class AbstractTreeWindow extends AbstractWorkPaneWindow {
    static Object toDisplay;
		private Utilisateur user;

    public AbstractTreeWindow(Utilisateur user) {
	    this.user = user;
    }
    
    /**
     * Allow to change the right pane.
     * @param toDisplay pane to display
     */
    void changeRightPane(Object toDisplay) {
        AbstractTreeWindow.toDisplay = toDisplay;
        createRightPane(rightWindowComponent);
        refreshRightPane();
    }

    @Override
    public void createLeftPane(JPanel panel) {
        panel.setPreferredSize(new Dimension(390, 500));
        JPanel container = new JPanel();

        final JTree jTree = new JTree();
        WSTreeNode WSTreeModel = new WSTreeNode(user);
        jTree.setModel(WSTreeModel);
        toDisplay = WSTreeModel.getRoot();
        if (toDisplay == null) {
        	toDisplay = new WorkSpace();
        }

        jTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Object o = jTree.getLastSelectedPathComponent();
                if (o instanceof WorkSpace) {
                    System.out.println("WS!!");
                    toDisplay = o;
                    createRightPane(rightWindowComponent);
                    refreshRightPane();
                } else if (o instanceof WorkPackage) {
                    toDisplay = o;
                    createRightPane(rightWindowComponent);
                    refreshRightPane();
                }
            }
        });

        container.add(jTree);
        panel.add(container);
    }

    @Override
    public void createRightPane(JPanel panel) {
        panel.setPreferredSize(new Dimension(390, 500));
        if (panel.getComponents().length == 0) {
            if (toDisplay instanceof WorkSpace) {
                panel.add(createWSPane((WorkSpace) toDisplay));
            } else {
                panel.add(createWPPane((WorkPackage) toDisplay));
            }
        } else {
            if (toDisplay instanceof WorkSpace) {
                panel.remove(0);
                panel.add(createWSPane((WorkSpace) toDisplay));
            } else {
                panel.remove(0);
                panel.add(createWPPane((WorkPackage) toDisplay));
            }
        }
    }

    /**
     * Here we create the display off the given WS.
     *
     * @param toDisplay WS to display
     * @return The Component created.
     */
     JComponent createWSPane(WorkSpace toDisplay) {
        return new JTextArea("WS");
     }

    /**
     * Here we create the display off the given WP.
     *
     * @param toDisplay WP to display
     * @return The Component created.
     */
    JComponent createWPPane(WorkPackage toDisplay) {
        return new JTextArea("WP");
    }
}
