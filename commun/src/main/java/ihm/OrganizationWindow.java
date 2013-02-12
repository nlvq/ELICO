package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListDataListener;

import ihm.simulate.SimulateUser;

/**
 * Class that allow to create a window where we can create a new organization.
 */
public class OrganizationWindow extends AbstractValidateCancelWindow {
    JTextField nameField;
    JTextField searchField;

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
        JPanel center = new JPanel(new BorderLayout());


        JLabel newOrg = new JLabel("New Organization");
        nameField = new JTextField();
        final JList<SimulateUser> users = new JList<>();
        searchField = new JTextField(10);
        JButton button = new JButton("Ok");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final List<SimulateUser> result = SimulateUser.findByName(searchField.getText());
                users.setModel(new ListModel<SimulateUser>() {
                    @Override
                    public int getSize() {
                        return result.size();
                    }

                    @Override
                    public SimulateUser getElementAt(int index) {
                        return result.get(index);
                    }

                    @Override
                    public void addListDataListener(ListDataListener l) {

                    }

                    @Override
                    public void removeListDataListener(ListDataListener l) {

                    }
                });
            }
        });

        north.add(newOrg, BorderLayout.NORTH);
        north.add(nameField, BorderLayout.SOUTH);

        center.add(searchField, BorderLayout.WEST);
        center.add(button, BorderLayout.EAST);

        panel.add(north, BorderLayout.NORTH);
        panel.add(users, BorderLayout.WEST);
        panel.add(center, BorderLayout.CENTER);
    }
}
