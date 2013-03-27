package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import main.ContextUtil;

import dao.Objet;

public class Editor extends AbstractButtonWindow {
	private JTextPane textPane;
	private JTextPane commentPane;
	
	private Objet objet;
	
	public Editor(Objet obj) {
	  objet = obj;
		
		textPane = new JTextPane();
	  textPane.setText(obj.getContent());
	  
	  commentPane = new JTextPane();
	  if (obj.getMaturite() != null) {
	  	commentPane.setText(obj.getMaturite().getCommentary());	  	
	  }
	  
	  textPane.setPreferredSize(new Dimension(380, 500));
	  commentPane.setPreferredSize(new Dimension(380, 500));
  }
	
	@Override
	public void createWindow() {
	  super.createWindow();
	  
	  frame.setTitle("Elico - Editor");
	  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
  void createButtonPane(JPanel panel) {
		JButton save = new JButton("Save");
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				objet.setContent(textPane.getText());
				ContextUtil.getLivre().updateObject(objet);
			}
		});
		
		panel.add(save);
	  panel.add(new JButton("?"));
  }

	@Override
  void createWindowPane(JPanel panel) {
		panel.setLayout(new BorderLayout());
		panel.add(textPane, BorderLayout.WEST);
		panel.add(commentPane, BorderLayout.EAST);
  }
}