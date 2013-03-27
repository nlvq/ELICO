package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListDataListener;

import main.ContextUtil;

import dao.IOrganisationDAO;
import dao.Organisation;
import dao.Role;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;
import dao.WorkPackage;
import dao.WorkSpace;

/**
 * Class that allow to create a window where we can create a new organization.
 */
public class OrganizationWindow extends AbstractValidateCancelWindow {
    JTextField nameField;
    JTextField searchField;
    JList<Utilisateur> users;

    Organisation parent;

    /**
     * Set the parent of the organization
     * @param parent New parent of the organization
     */
    public void setParent(Organisation parent) {
        this.parent = parent;
    }

    @Override
    public void createWindow() {
        super.createWindow();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    void createValidateButton(JButton button) {
        button.setText("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            		Organisation newOrg = new Organisation();
            		newOrg.setParent(parent);
            		newOrg.setTitle(nameField.getText());

            		List<UtilisateurOrganisationRole> appartient = new ArrayList<>();
            		UtilisateurOrganisationRole uor = new UtilisateurOrganisationRole();

            		Role role = new Role();
            		role.setTitle("admin");
            		uor.setRole(role);
            		uor.setUtilisateur(users.getSelectedValue());
            		uor.setOrganisation(newOrg);

            		appartient.add(uor);
            		newOrg.setAppartient(appartient);
            		
            		newOrg.setChilds(new ArrayList<Organisation>());
            		newOrg.setWorkpackages(new ArrayList<WorkPackage>());
            		newOrg.setWorkspaces(new ArrayList<WorkSpace>());

            		parent.getChilds().add(newOrg);
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
        panel.setLayout(new BorderLayout());

        JPanel north = new JPanel(new BorderLayout());
        JPanel center = new JPanel();

        JLabel newOrg = new JLabel("New Organization");
        nameField = new JTextField();
        users = new JList<>();
        searchField = new JTextField(10);
        JButton button = new JButton("Ok");

        final List<Utilisateur> result = new ArrayList<>();
        
        if (parent != null) {
          for (UtilisateurOrganisationRole uor: parent.getAppartient()) {
          	  result.add(uor.getUtilisateur());
          }
        }
        
        users.setModel(createList(result));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final List<Utilisateur> result = ContextUtil.getRH().findUser(searchField.getText());
                users.setModel(createList(result));
            }
        });

        north.add(newOrg, BorderLayout.NORTH);
        north.add(nameField, BorderLayout.SOUTH);

        center.add(users);
        center.add(searchField);
        center.add(button);

        panel.add(north, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);
    }

    private ListModel<Utilisateur> createList(final List<Utilisateur> result) {
        return new ListModel<Utilisateur>() {
            @Override
            public int getSize() {
                return result.size();
            }

            @Override
            public Utilisateur getElementAt(int index) {
                return result.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {

            }

            @Override
            public void removeListDataListener(ListDataListener l) {

            }
        };
    }
}
