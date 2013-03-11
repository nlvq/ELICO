package ihm;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.Organisation;
import dao.WorkPackage;
import dao.WorkSpace;

public class AddWSWindow extends AbstractValidateCancelWindow {
    JTextField fieldName;
    JList<Organisation> orgs;
    JList<WorkPackage> possibleWP;
    JList<WorkPackage> toAddWP;

    List<WorkPackage> possibleWPList;
    List<WorkPackage> toAddWPList;

    Organisation parent;

    public AddWSWindow(Organisation parent) {
        this.parent = parent;
    }

    @Override
    void createValidateButton(JButton button) {
        button.setText("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  WorkSpace ws = new WorkSpace();
            	  ws.setChilds(new ArrayList<WorkSpace>());
            	  ws.setOrganisation(parent);
            	  ws.setTitle(fieldName.getText());
            	  ws.setWorkpackages(toAddWPList);
            	  ws.setParent(parent.getWorkspaces().get(0));
            		parent.getWorkspaces().add(ws);
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
        orgs = new JList<>();
        possibleWP = new JList<>();
        toAddWP = new JList<>();
        JButton add = new JButton("<-");
        JButton remove = new JButton("->");

        JLabel orga = new JLabel("Organisme qui aura le WS");
        JLabel possible = new JLabel("WP possibles :");
        JLabel toAdd = new JLabel("WP sélectionnés :");

        List<Organisation> orgsList = parent.getChilds();
        possibleWPList = parent.getWorkpackages();
        toAddWPList = new ArrayList<>();

        orgs.setListData(orgsList.toArray(new Organisation[1]));
        possibleWP.setListData(possibleWPList.toArray(new WorkPackage[1]));

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  WorkPackage selectedValue = possibleWP.getSelectedValue();
                toAddWPList.add(selectedValue);
                possibleWPList.remove(selectedValue);

                toAddWP.setListData(toAddWPList.toArray(new WorkPackage[1]));
                possibleWP.setListData(possibleWPList.toArray(new WorkPackage[1]));

                toAddWP.validate();
                toAddWP.repaint();
                possibleWP.validate();
                possibleWP.repaint();
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  WorkPackage selectedValue = toAddWP.getSelectedValue();
                toAddWPList.remove(selectedValue);
                possibleWPList.add(selectedValue);

                toAddWP.setListData(toAddWPList.toArray(new WorkPackage[1]));
                possibleWP.setListData(possibleWPList.toArray(new WorkPackage[1]));

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
