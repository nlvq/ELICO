package ihm;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;

import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

/**
 * Abstract class which should be use by all user view.
 * All this view uses two panes and a button line.
 * The left pane is filled with a tree.
 * ..........................
 * That class provide a button panel and two panels to fill.
 */
public abstract class AbstractTreeWindow extends AbstractWorkPaneWindow {
    static Object toDisplay;

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
        WSTreeNode WSTreeModel = new WSTreeNode();
        jTree.setModel(WSTreeModel);
        toDisplay = WSTreeModel.getRoot();

        jTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Object o = jTree.getLastSelectedPathComponent();
                if (o instanceof SimulateWS) {
                    System.out.println("WS!!");
                    toDisplay = o;
                    createRightPane(rightWindowComponent);
                    refreshRightPane();
                } else if (o instanceof SimulateWP) {
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
            if (toDisplay instanceof SimulateWS) {
                panel.add(createWSPane((SimulateWS) toDisplay));
            } else {
                panel.add(createWPPane((SimulateWP) toDisplay));
            }
        } else {
            if (toDisplay instanceof SimulateWS) {
                panel.remove(0);
                panel.add(createWSPane((SimulateWS) toDisplay));
            } else {
                panel.remove(0);
                panel.add(createWPPane((SimulateWP) toDisplay));
            }
        }
    }

    /**
     * Here we create the display off the given WS.
     *
     * @param toDisplay WS to display
     * @return The Component created.
     */
     JComponent createWSPane(SimulateWS toDisplay) {
        return new JTextArea("WS");
     }

    /**
     * Here we create the display off the given WP.
     *
     * @param toDisplay WP to display
     * @return The Component created.
     */
    JComponent createWPPane(SimulateWP toDisplay) {
        return new JTextArea("WP");
    }
}
