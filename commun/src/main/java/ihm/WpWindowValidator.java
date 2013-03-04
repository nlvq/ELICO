package ihm;

import ihm.simulate.SimulateObjet;
import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class WpWindowValidator extends AbstractTreeWindow {
	 private SimulateObjet selectedObject;
	 static Object toDisplay;
	    private SimulateWP selectedWP;
	
	
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
