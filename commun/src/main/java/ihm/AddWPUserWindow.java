package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import main.ContextUtil;

import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;
import dao.WorkPackage;

public class AddWPUserWindow extends AbstractValidateCancelWindow {
    JList<Utilisateur> users;
    JTextField searchField;
    JList<Role> jobs;
    private WorkPackage wp;

    public AddWPUserWindow(WorkPackage wp) {
        this.wp = wp;
    }

    @Override
    void createValidateButton(JButton button) {
        button.setText("Add user");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Role job = jobs.getSelectedValue();
                Utilisateur user = users.getSelectedValue();

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

                UtilisateurOrganisationRole uor = new UtilisateurOrganisationRole();
                uor.setOrganisation(wp.getOrganisation());
                uor.setRole(job);
                uor.setUtilisateur(user);
                wp.getOrganisation().getAppartient().add(uor);
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
                List<Utilisateur> byName = ContextUtil.getRH().findUser(searchField.getText());
                users.setListData(byName.toArray(new Utilisateur[1]));
            }
        });
        
        List<Utilisateur> users2 = new ArrayList<>();
        for (UtilisateurOrganisationRole uor: wp.getOrganisation().getAppartient()) {
        	users2.add(uor.getUtilisateur());
        }

        users.setListData(users2.toArray(new Utilisateur[1]));

        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role();
        role1.setTitle("Superviseur");
        Role role2 = new Role();
        role2.setTitle("Ingénieur");
        Role role3 = new Role();
        role3.setTitle("Validateur");
        
        roles.add(role1);
        roles.add(role2);
        roles.add(role3);
        
        jobs.setListData(roles.toArray(new Role[1]));

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
