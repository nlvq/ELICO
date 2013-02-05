package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ihm.simulate.SimulateRH;

public class AddUserWindow extends AbstractValidateCancelWindow {

    private JTextField firstNameField = new JTextField(20);
    private JTextField lastNameField = new JTextField(20);
    private JTextField loginField = new JTextField(20);
    private JTextField passwordField = new JTextField(20);
    private JTextField phoneNumberField = new JTextField(20);

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
                SimulateRH rh = new SimulateRH();
                rh.createNewUser(firstNameField.getText(), lastNameField.getText(), loginField.getText(),
                        passwordField.getText(), phoneNumberField.getText());
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
        GroupLayout layout = new GroupLayout(panel);

        JLabel firstNameLabel = new JLabel("FirstName");
        JLabel lastNameLabel = new JLabel("LastName");
        JLabel loginLabel = new JLabel("Login");
        JLabel passwordLabel = new JLabel("Password");
        JLabel phoneNumberLabel = new JLabel("Phone number");

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(firstNameLabel)
                .addComponent(loginLabel)
                .addComponent(phoneNumberLabel));

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(firstNameField)
                .addComponent(loginField)
                .addComponent(phoneNumberField));

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(lastNameLabel)
                .addComponent(passwordLabel));

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(lastNameField)
                .addComponent(passwordField));

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(firstNameLabel)
                .addComponent(firstNameField)
                .addComponent(lastNameLabel)
                .addComponent(lastNameField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(loginLabel)
                .addComponent(loginField)
                .addComponent(passwordLabel)
                .addComponent(passwordField));

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(phoneNumberLabel)
                .addComponent(phoneNumberField));

        layout.setVerticalGroup(vGroup);

        panel.setLayout(layout);
    }
}
