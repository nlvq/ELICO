package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dao.Utilisateur;

public class WpWindowValidator extends AbstractTreeWindow {
	private Utilisateur user;
	 public WpWindowValidator(Utilisateur user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	//static Object toDisplay;
	    	
	
	@Override
	public void createRightPane(JPanel panel) {
	super.createRightPane(panel);
	}

	@Override
	public void createLeftPane(JPanel panel) {
		super.createLeftPane(panel);
		panel.setBackground(Color.WHITE);
    	panel.setPreferredSize(new Dimension (400,500));
	
	}

	@Override
	public void createWindow() {
		// TODO Auto-generated method stub
		super.createWindow();
		
		
	}

	@Override
	void createButtonPane(JPanel panel) {
		JButton A = new JButton("A");
	    JButton UN = new JButton("1");
	    JButton help = new JButton("?");
	    UN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });

	        
	        panel.add(A);
	        panel.add(UN);
	        panel.add(help);
	}
	
}
