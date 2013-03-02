package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import ihm.simulate.SimulateObjet;

import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

public class ValidatorWindow extends Validate{
	@Override
	public void createWindow() {
		super.createWindow();
		frame.setTitle("Elico-validator");
	}

	private SimulateObjet selectedObject;
    private SimulateWP selectedWP;

    @Override
	public void createLeftPane(JPanel panel) {
		super.createLeftPane(panel);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension (1200,500));
	}




	@Override
	public void createRightPane(JPanel panel) {
		
		super.createRightPane(panel);
		panel.setBackground(Color.WHITE);
	}

	JButton A = new JButton("A");
	    JButton UN = new JButton("1");
	    JButton help = new JButton("?");

    @Override
    void createButtonPane(JPanel panel) {
   
   
	         
 A.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			}
		});
 UN.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			

		}
	});
 UN.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		System.out.println("help indispo");	

		}
	});
	    
	    
	        panel.add(A);
	        panel.add(UN);
	        panel.add(help);
	         
	        }
	
	
    

    @Override
    JComponent createWSPane(SimulateWS toDisplay) {
        final List<SimulateWP> wps = toDisplay.getWorkpackages();
        final JList<SimulateWP> jList = new JList<>(new ListModel<SimulateWP>() {
            @Override
            public int getSize() {
                return wps.size();
            }

            @Override
            public SimulateWP getElementAt(int index) {
                return wps.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
            	A.addActionListener(new ActionListener() {
        			
        			@Override
        			public void actionPerformed(ActionEvent e) {
        			
        			}
        		});
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
                //TODO ?
            }
        });

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    changeRightPane(jList.getModel().getElementAt(jList.locationToIndex(e.getPoint())));
                } else if (e.getClickCount() == 1) {
                    selectedWP = jList.getModel().getElementAt(jList.locationToIndex(e.getPoint()));
                }
            }
        });
        JScrollPane scroll =new JScrollPane(jList);
        scroll.setPreferredSize(new Dimension(765, 490));
                return  scroll;

        
    }

    @Override
    JComponent createWPPane(SimulateWP toDisplay) {
        final List<SimulateObjet> objects = toDisplay.getObjects();
        final JList<SimulateObjet> jList = new JList<>(new ListModel<SimulateObjet>() {
            @Override
            public int getSize() {
                return objects.size();
            }

            @Override
            public SimulateObjet getElementAt(int index) {
                return objects.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
           
            
            }
            @Override
            public void removeListDataListener(ListDataListener l) {
                //TODO ?
            }
        });

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    System.out.println("Open Editor for: " +
                            jList.getModel().getElementAt(jList.locationToIndex(e.getPoint())));
                    CommentValid cmt=new CommentValid( jList.getModel().getElementAt(jList.locationToIndex(e.getPoint())));
                    cmt.createWindow();
                    cmt.openWindow();
                    
                } else if (e.getClickCount() == 1) {
                   selectedObject = jList.getModel().getElementAt(jList.locationToIndex(e.getPoint()));
                  
                }
            }
        });
        
        
       

       
JScrollPane scroll =new JScrollPane(jList);
scroll.setPreferredSize(new Dimension(765, 490));
        return  scroll;
    }
    
    
}
