package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import org.h2.constant.SysProperties;

import main.ContextUtil;

import dao.Organisation;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;
import dao.WorkPackage;
import dao.impl.DefaultUtilisateurOrganisationRoleDAO;

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
                Utilisateur user = ContextUtil.getRH().getUtilisateurDAO().findUtilisateur(users.getSelectedValue()).get(0);

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
                
                Organisation org = ContextUtil.getRH().findOrga("Elico").get(0);

                UtilisateurOrganisationRole uor = new UtilisateurOrganisationRole();
                uor.setOrganisation(org);
                uor.setRole(job);
                uor.setUtilisateur(user);
                
                System.out.println(job.getTitle());
                
                List<UtilisateurOrganisationRole> appartient = user.getAppartient();
								appartient.add(uor);
                
								ContextUtil.getRH().setRoles(user.getLogin(), appartient);
								
								System.out.println(ContextUtil.getRH().findUser(user.getLogin()).get(0).getAppartient());
								
                org.getAppartient().add(uor);
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
        if (wp.getOrganisation() != null) {
          for (UtilisateurOrganisationRole uor: wp.getOrganisation().getAppartient()) {
          	users2.add(uor.getUtilisateur());
          }
        }

        users.setListData(users2.toArray(new Utilisateur[1]));

        ArrayList<Role> roles = new ArrayList<>();
        Role role1 = new Role();
        role1.setTitle("supervisor");
        Role role2 = new Role();
        role2.setTitle("engineer");
        Role role3 = new Role();
        role3.setTitle("validator");
        
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
