package ihm;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.Role;
import dao.Utilisateur;

public class AuthentificationWindow extends AbstractValidateCancelWindow {
	
	private Utilisateur utilisateur;
	private List<Role> roles;
	private JComboBox<Object> listRoles;
	
	public AuthentificationWindow(Utilisateur utilisateur, List<Role> roles) {
		this.utilisateur = utilisateur;
		this.roles = roles;
	}

	@Override
	void createValidateButton(JButton button) {
		button.setText("Choose");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IWindow window = null;
				switch ((String) listRoles.getSelectedItem()) {
				case "admin":
					window = new AdminWindow();
					break;
				case "supervisor":
					window = new SupervisorWindow(utilisateur);
					break;
				case "validator":
					window = new ValidatorWindow();
					break;
				case "engineer":
					window = new IngWindow(utilisateur);
					break;
				default:
					throw new IllegalArgumentException("Unknow role");
				}
				window.createWindow();
				window.openWindow();
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
		ArrayList<String> rolesTitle = new ArrayList<String>();
		for(Role role: roles){
			rolesTitle.add(role.getTitle());
		}
		listRoles = new JComboBox<Object>(rolesTitle.toArray());
		listRoles.setPreferredSize(new Dimension(100,25));
		
		
		GroupLayout layout = new GroupLayout(panel);

		JLabel rolesLabel = new JLabel("Roles: ");

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

		hGroup.addGroup(layout.createParallelGroup().addComponent(rolesLabel));

		hGroup.addGroup(layout.createParallelGroup().addComponent(listRoles));

		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		vGroup.addGroup(layout
				.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(rolesLabel).addComponent(listRoles));

		layout.setVerticalGroup(vGroup);

		panel.setLayout(layout);
	}

}
