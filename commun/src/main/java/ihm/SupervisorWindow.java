package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListDataListener;

import ihm.simulate.SimulateObjet;
import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

public class SupervisorWindow extends AbstractTreeWindow {
    private SimulateObjet selectedObject;
    private SimulateWP selectedWP;


    @Override
    void createButtonPane(JPanel panel) {
        JButton A = new JButton("A");
        JButton PU = new JButton("PU");
        JButton PR = new JButton("PR");
        JButton S = new JButton("S");
        JButton WP = new JButton("WP");
        JButton WS = new JButton("WS");
        JButton O = new JButton("O");
        JButton plus = new JButton("+");
        JButton rmWP = new JButton("-WP");
        JButton help = new JButton("?");

        O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrganizationWindow org = new OrganizationWindow();
                org.createWindow();
                if (selectedWP != null) {
                    org.setParent(selectedWP.getParentWS().getOrg());
                } if (selectedObject != null) {
                    org.setParent(selectedObject.getParent().getParentWS().getOrg());
                }
                org.openWindow();
            }
        });

        panel.add(A);
        panel.add(PU);
        panel.add(PR);
        panel.add(S);
        panel.add(WP);
        panel.add(WS);
        panel.add(O);
        panel.add(plus);
        panel.add(rmWP);
        panel.add(help);
    }

    @Override
    JComponent createWSPane(SimulateWS toDisplay) {
        final List<SimulateWP> wps = toDisplay.getWorkpackages();
        final JList<SimulateWP> jList = new JList<>(new ListModel<SimulateWP>() {
            @Override
            public int getSize() {
                return wps.size();
            }

            @Override
            public SimulateWP getElementAt(int index) {
                return wps.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
                // TODO ?
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
                //TODO ?
            }
        });

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    changeRightPane(jList.getModel().getElementAt(jList.locationToIndex(e.getPoint())));
                } else if (e.getClickCount() == 1) {
                    selectedWP = jList.getModel().getElementAt(jList.locationToIndex(e.getPoint()));
                }
            }
        });

        return new JScrollPane(jList);
    }

    @Override
    JComponent createWPPane(SimulateWP toDisplay) {
        final List<SimulateObjet> objects = toDisplay.getObjects();
        final JList<SimulateObjet> jList = new JList<>(new ListModel<SimulateObjet>() {
            @Override
            public int getSize() {
                return objects.size();
            }

            @Override
            public SimulateObjet getElementAt(int index) {
                return objects.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
                // TODO ?
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
                //TODO ?
            }
        });

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("Open Editor for: " +
                            jList.getModel().getElementAt(jList.locationToIndex(e.getPoint())));
                } else if (e.getClickCount() == 1) {
                    selectedObject = jList.getModel().getElementAt(jList.locationToIndex(e.getPoint()));
                }
            }
        });

        return new JScrollPane(jList);
    }
}
