package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;

import dao.Objet;
import dao.Maturite.Etat;
/*Create wa window for Validator*/
public class CommentValid extends AbstractValidateCancelWindow{
	
	private Objet objet;
	JTextArea area = new JTextArea();
	JTextArea area1 = new JTextArea();
	public CommentValid(Objet objet) {
		super();
		this.objet = objet;
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
		bar.add(help);
		menu.add(styleMenu);
		bar.setMargin(margins);
		north.setLayout(new BorderLayout() );
		north.add(bar,BorderLayout.WEST);
		panel.setLayout(new BorderLayout());
		JLabel nameText = new JLabel("       WP                                                                        " +
				"                                            Comment");
		
		area.setPreferredSize(new Dimension(300, 200));
        JPanel center=new JPanel(new BorderLayout());
        center.add(nameText,BorderLayout.NORTH);
        JPanel cent=new JPanel();
        area1.setPreferredSize(new Dimension(350, 450));
        area1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cent.add(area1);
        area1.setText(objet.getContent());
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
	          objet.getMaturite().setTitle(Etat.VALIDED);   // le bouton permet de valider un objet  
	          objet.getMaturite().setCommentary(area.getText());
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
	           objet.getMaturite().setTitle(Etat.REFUSED); // bouton pour refuser la validation d'un objet
	           objet.getMaturite().setCommentary(area.getText());
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
		public void actionPerformed(ActionEvent e) {
		objet.getMaturite().setCommentary(area.getText());
		}
	}
	

}
