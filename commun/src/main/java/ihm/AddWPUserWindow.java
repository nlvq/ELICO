package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import ihm.simulate.SimulateJob;
import ihm.simulate.SimulateUser;
import ihm.simulate.SimulateWP;

public class AddWPUserWindow extends AbstractValidateCancelWindow {
    JList<SimulateUser> users;
    JTextField searchField;
    JList<SimulateJob> jobs;
    private SimulateWP wp;

    public AddWPUserWindow(SimulateWP wp) {
        this.wp = wp;
    }

    @Override
    void createValidateButton(JButton button) {
        button.setText("Add user");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulateJob job = jobs.getSelectedValue();
                SimulateUser user = users.getSelectedValue();

                if (job == null) {
                    JOptionPane.showMessageDialog(frame, "Veuillez choisir un rôle !", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (user == null) {
                    JOptionPane.showMessageDialog(frame, "Veuillez choisir un utilisateur !", "Erreur",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                wp.addUser(user, job);
                frame.dispose();
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
        JLabel searchLabel = new JLabel("Rechercher un utilisateur : ");
        searchField = new JTextField(30);
        JButton searchButton = new JButton("Rechercher");
        users = new JList<>();
        JLabel jobLabel = new JLabel("Rôle : ");
        jobs = new JList<>();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<SimulateUser> byName = SimulateUser.findByName(searchField.getText());
                users.setListData(byName.toArray(new SimulateUser[1]));
            }
        });

        users.setListData(wp.getUsers().toArray(new SimulateUser[1]));

        jobs.setListData(SimulateJob.getJobs().toArray(new SimulateJob[1]));

        panel.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        JPanel panelEast = new JPanel();

        panelNorth.add(searchLabel);
        panelNorth.add(searchField);
        panelNorth.add(searchButton);

        panelEast.add(jobLabel);
        panelEast.add(jobs);

        panel.add(panelNorth, BorderLayout.NORTH);
        panel.add(users, BorderLayout.WEST);
        panel.add(panelEast, BorderLayout.EAST);
    }
}
