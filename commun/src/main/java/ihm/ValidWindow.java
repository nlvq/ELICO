package ihm;




import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JPanel;



public class ValidWindow extends AbstractButtonWindow{
	
	 @Override
	public void createWindow() {
		super.createWindow();
		frame.setTitle("Workpackage");
	}



	public ValidWindow(JComponent component) {
		super();
		this.component = component;
		
	}


private JComponent component;
	 static Object toDisplay;
	    
    
	  	@Override
	void createWindowPane(JPanel panel) {
	  		
	  		
		   
		   
		  	JButton openButton = new JButton("ok");
		  	
		    JButton returnButton = new JButton("Retour");
		   
		    
		  	    openButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					

				}
			});
		    
		    
		    returnButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        
		          
		        }
		        });
		    
		  
		     
		      panel.setLayout(new BorderLayout());
		      panel.add(component, BorderLayout.CENTER);
			     
		      JPanel p=new JPanel();
		     
		      p.add(openButton);
		      p.add(returnButton);
		  
		      
		      panel.add(p, BorderLayout.SOUTH);
	
	}
	  	
	    
	   
	@Override
	    void createButtonPane(JPanel panel) {
		JButton A = new JButton("A");
	    JButton UN = new JButton("1");
	    JButton help = new JButton("?");
	          
	         
	         
	        
	        panel.add(A);
	        panel.add(UN);
	        panel.add(help);
	         
	        }
	
	
	
	
  }
