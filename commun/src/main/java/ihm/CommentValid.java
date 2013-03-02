package ihm;

import ihm.simulate.SimulateObjet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;
/*Create wa window for Validator*/
public class CommentValid extends AbstractValidateCancelWindow{
	private SimulateObjet sim_objet;
	

	public CommentValid(SimulateObjet sim_objet) {
		super();
		this.sim_objet = sim_objet;
	}

	@Override
	void createWindowPane(JPanel panel) {
		JButton help = new JButton("?");
		JPanel north = new JPanel();
		JMenuBar menu = new JMenuBar();
		JMenu styleMenu = new JMenu();
		JToolBar bar = new JToolBar();	
		Action saveAction = new SaveAction();
		saveAction.putValue(Action.NAME, "Save");
		styleMenu.add(saveAction);
		bar.add(saveAction);	
		Action boldAction = new BoldAction();
		boldAction.setEnabled(false);
		boldAction.putValue(Action.NAME, "Bold");
		styleMenu.add(boldAction);
		bar.add(boldAction);
		Action italicAction = new ItalicAction();
		italicAction.setEnabled(false);
		italicAction.putValue(Action.NAME, "Italic");
		styleMenu.add(italicAction);
		bar.add(italicAction);
		Action underlineAction = new UnderlineAction();
		underlineAction.setEnabled(false);
		boldAction.setEnabled(false);
		underlineAction.putValue(Action.NAME, "Underline");
		styleMenu.add(underlineAction);
		bar.add(underlineAction);
		bar.add(help);
		menu.add(styleMenu);
		bar.setMargin(margins);
		north.setLayout(new BorderLayout() );
		north.add(bar,BorderLayout.WEST);
		panel.setLayout(new BorderLayout());
		JLabel nameText = new JLabel("       WP                                                                        " +
				"                                            Comment");
		JTextArea area = new JTextArea();
		JTextArea area1 = new JTextArea();
		area.setPreferredSize(new Dimension(300, 200));
        JPanel center=new JPanel(new BorderLayout());
        center.add(nameText,BorderLayout.NORTH);
        JPanel cent=new JPanel();
        area1.setPreferredSize(new Dimension(350, 450));
        area1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cent.add(area1);
        area1.setText("contenu de lobjet");
        area1.setEnabled(false);
        center.add(cent,BorderLayout.CENTER);
        area.setPreferredSize(new Dimension(350, 450));
        area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cent.add(area);
        center.add(cent,BorderLayout.CENTER);
		panel.add(north,BorderLayout.NORTH);
		panel.add(center,BorderLayout.CENTER);
		JPanel bPanel=new JPanel();
		bPanel.add(cancelButton);
		bPanel.add(validateButton);
		JPanel b=new JPanel();
		b.setLayout(new BorderLayout());
		b.add(bPanel,BorderLayout.EAST);
		panel.add(b,BorderLayout.SOUTH);
	
	}

	 private static final Insets margins =
				new Insets(0,370, 0, 0);
 

	@Override
	void createValidateButton(JButton button) {
		 button.setText("Valider");
	        button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	//mettre a jour l'objet 
	            	
	            	
	            	frame.dispose();
	            
	           }
	        });
		
	}

	@Override
	void createCancelButton(JButton button) {
		button.setText("Refuser");
		 button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("wp refusee");
	            	frame.dispose();
	                }
	        });
		
	}
	class SaveAction extends StyledEditorKit.StyledTextAction {

		private static final long serialVersionUID = -6228768835751837002L;

		public SaveAction() {
			super("Save");
		}

		public String toString() {
			return "Save";
		}


		// invoked when "Underline" button is clicked
		public void actionPerformed(ActionEvent e) {
			// To Do
		}
	}
	

}
