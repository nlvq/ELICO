package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.ContextUtil;
import coeur_metier.authentification.AuthentificationImpl;
import dao.Role;
import dao.Utilisateur;

public class AuthentificationLoginWindow extends AbstractValidateCancelWindow {

	private JTextField loginField = new JTextField(20);
	private JTextField passwordField = new JTextField(20);
	private JLabel errorLabel = new JLabel("");

	@Override
	void createValidateButton(JButton button) {
		button.setText("Connect");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AuthentificationImpl authentification = ContextUtil.getAuthentification();
				List<Role> roles = authentification.auth(loginField.getText(), passwordField.getText());
				Utilisateur utilisateur = ContextUtil.getRH().findUser(loginField.getText()).get(0);
				if(roles!=null){
					AuthentificationWindow authentificationWindow = new AuthentificationWindow(utilisateur, roles);
					authentificationWindow.createWindow();
					authentificationWindow.openWindow();
					frame.dispose();
				}
				else{
					errorLabel.setText("Wrong username or password (for a test try admin:admin).");
					loginField.setText("");
					passwordField.setText("");
				}
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

		JLabel loginLabel = new JLabel("Login");
		JLabel passwordLabel = new JLabel("Password");

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		
		hGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup().addComponent(loginLabel))
						.addGroup(layout.createParallelGroup().addComponent(loginField))
						.addGroup(layout.createParallelGroup().addComponent(passwordLabel))
						.addGroup(layout.createParallelGroup().addComponent(passwordField)))
				.addComponent(errorLabel));

		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		vGroup.addGroup(layout
				.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(loginLabel).addComponent(loginField)
				.addComponent(passwordLabel).addComponent(passwordField));

		vGroup.addGroup(layout
				.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(errorLabel));

		layout.setVerticalGroup(vGroup);

		panel.setLayout(layout);
	}

}
