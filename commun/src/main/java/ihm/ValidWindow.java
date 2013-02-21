package ihm;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import ihm.simulate.SimulateObjet;
import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import net.sf.cglib.proxy.Factory;



public class ValidWindow extends AbstractButtonWindow{
	private int counter;
	private JList list;
	private DefaultListModel model;
    private Editor edt;
    private static final Insets margins =
			new Insets(0, 0, 0, 0);
	  	@Override
	void createWindowPane(JPanel panel) {
	  		
	  		model = new DefaultListModel();
		    list = new JList(model);
		   
		    JScrollPane pane = new JScrollPane(list); 
		  	JButton openButton = new JButton("ok");
		  	
		    JButton returnButton = new JButton("Retour");
		    
		    for (int i = 0; i < 15; i++)
		        model.addElement("Element " + i);    //juste pour simuler !!!!
		    openButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					Commentaire();
					// TODO Auto-generated method stub
					//edt=new Editor();

				}
			});
		    
		    
		    returnButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		          ///fermer lediteur 
		          
		        }
		        });
		    
		      list.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                if (e.getClickCount() == 2) {
		                	edt=new Editor();    
		                	
		                }
		            }
		        });
		     
		     
		      panel.setLayout(new BorderLayout());
		        panel.add(pane, BorderLayout.CENTER);
		     JPanel p=new JPanel();
		     
		      p.add(openButton);
		      p.add(returnButton);
		      panel.add(p, BorderLayout.SOUTH);
		     
		       

		        
	        
		
	}
	  	public void Commentaire(){
	  		JFrame comment = new JFrame();
			JTextPane textPane = new JTextPane();
			JScrollPane scrollPane = new JScrollPane(textPane);
			JTextPane textPane2 = new JTextPane();
			JScrollPane scrollPane2 = new JScrollPane(textPane2);
			JPanel north = new JPanel();

			JMenuBar menu = new JMenuBar();
			JMenu styleMenu = new JMenu();
			styleMenu.setText("espace validation");

			JToolBar bar = new JToolBar();
			
			
			Action openAction = new OpenAction();
			openAction.putValue(Action.NAME, "Open");
			styleMenu.add(openAction);
			bar.add(openAction);

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

			menu.add(styleMenu);

			bar.setMargin(margins);

			// positions of components
			north.add(bar);
			comment.getContentPane().setLayout(new BorderLayout());
			comment.setJMenuBar(menu);
			JButton validate = new JButton("Valider");
	        JButton refuse = new JButton("Refuser");
	        JPanel p=new JPanel();
	        p.setLayout(new  BorderLayout(200,500));
	        
		      p.add(validate,BorderLayout.EAST);
		      p.add(refuse,BorderLayout.WEST);
		      comment.add(p, BorderLayout.SOUTH);
		     
		  	comment.getContentPane().add(north, BorderLayout.NORTH);

			comment.getContentPane().add(scrollPane, BorderLayout.CENTER);
			
			comment.setSize(800, 500);
			comment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  					
	        comment.setVisible(true);
	
	        
	               
		     
	  		
	  	}
	  	
	
	@Override
	    void createButtonPane(JPanel panel) {
		JButton A = new JButton("A");
	    JButton UN = new JButton("1");
	         
	          A.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            model.removeAllElements();
			        
			       
			        }
			      });
	         
	         
	        JButton help = new JButton("?");
	        panel.add(A);
	        panel.add(UN);
	        panel.add(help);
	    
	      // ListModelExample(panel);
			         
	        }
	
	 @Override
	    public void createWindow() {
	        super.createWindow();
	        frame.setTitle("Elico - Validator");
	      
	 }
	 
	
  

}
