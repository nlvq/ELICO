package ihm;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ihm.simulate.SimulateOrg;
import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

public class AddWSWindow extends AbstractValidateCancelWindow {
    JTextField fieldName;
    JList<SimulateOrg> orgs;
    JList<SimulateWP> possibleWP;
    JList<SimulateWP> toAddWP;

    List<SimulateWP> possibleWPList;
    List<SimulateWP> toAddWPList;

    SimulateOrg parent;

    public AddWSWindow(SimulateOrg parent) {
        this.parent = parent;
    }

    @Override
    void createValidateButton(JButton button) {
        button.setText("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.addWS(new SimulateWS(new ArrayList<SimulateWS>(), parent, parent.getWS(), fieldName.getText(), toAddWPList));
            }
        });
    }

    @Override
    void createCancelButton(JButton button) {
        button.setText("Cancel");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    @Override
    void createWindowPane(JPanel panel) {
        panel.setLayout(new BorderLayout());

        JLabel name = new JLabel("Nom du nouveau WS :");
        fieldName = new JTextField(60);
        orgs = new JList();
        possibleWP = new JList<>();
        toAddWP = new JList<>();
        JButton add = new JButton("<-");
        JButton remove = new JButton("->");

        JLabel orga = new JLabel("Organisme qui aura le WS");
        JLabel possible = new JLabel("WP possibles :");
        JLabel toAdd = new JLabel("WP sélectionnés :");

        List<SimulateOrg> orgsList = parent.getChilds();
        possibleWPList = parent.getWPs();
        toAddWPList = new ArrayList<>();

        orgs.setListData(orgsList.toArray(new SimulateOrg[1]));
        possibleWP.setListData(possibleWPList.toArray(new SimulateWP[1]));

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulateWP selectedValue = possibleWP.getSelectedValue();
                toAddWPList.add(selectedValue);
                possibleWPList.remove(selectedValue);

                toAddWP.setListData(toAddWPList.toArray(new SimulateWP[1]));
                possibleWP.setListData(possibleWPList.toArray(new SimulateWP[1]));

                toAddWP.validate();
                toAddWP.repaint();
                possibleWP.validate();
                possibleWP.repaint();
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulateWP selectedValue = toAddWP.getSelectedValue();
                toAddWPList.remove(selectedValue);
                possibleWPList.add(selectedValue);

                toAddWP.setListData(toAddWPList.toArray(new SimulateWP[1]));
                possibleWP.setListData(possibleWPList.toArray(new SimulateWP[1]));

                toAddWP.validate();
                toAddWP.repaint();
                possibleWP.validate();
                possibleWP.repaint();
            }
        });

        JPanel north = new JPanel();
        north.add(name);
        north.add(fieldName);

        orgs.setPreferredSize(new Dimension(200, 100));

        JPanel west = new JPanel();
        west.setLayout(new BorderLayout());
        west.add(orga, BorderLayout.NORTH);
        west.add(orgs, BorderLayout.CENTER);

        toAddWP.setPreferredSize(new Dimension(100, 100));
        possibleWP.setPreferredSize(new Dimension(100, 100));

        JPanel panelAdd = new JPanel();
        panelAdd.setLayout(new BorderLayout());
        panelAdd.add(toAdd, BorderLayout.NORTH);
        panelAdd.add(toAddWP, BorderLayout.CENTER);

        JPanel panelPossible = new JPanel();
        panelPossible.setLayout(new BorderLayout());
        panelPossible.add(possible, BorderLayout.NORTH);
        panelPossible.add(possibleWP, BorderLayout.CENTER);

        JPanel east = new JPanel();
        east.add(panelAdd);
        east.add(add);
        east.add(remove);
        east.add(panelPossible);

        north.setPreferredSize(new Dimension(north.getPreferredSize().width, north.getPreferredSize().height * 2));

        panel.add(north, BorderLayout.NORTH);
        panel.add(west, BorderLayout.WEST);
        panel.add(east, BorderLayout.EAST);
    }
}
