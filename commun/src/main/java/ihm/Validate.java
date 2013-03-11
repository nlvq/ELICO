package ihm;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;


public abstract class Validate extends AbstractWorkPaneWindow {
		@Override
		void createButtonPane(JPanel panel) {

		}
	
		static Object toDisplay;
    
		void changeRightPane(Object toDisplay) {
        AbstractTreeWindow.toDisplay = toDisplay;
        createRightPane(rightWindowComponent);
        refreshRightPane();
    }

    @Override
    public void createLeftPane(JPanel panel) {
        panel.setPreferredSize(new Dimension(390, 500));
        JPanel container = new JPanel();

       final  JTree jTree = new JTree();
        // Change null to the user.
        WSTreeNode WSTreeModel = new WSTreeNode(null);
        jTree.setModel(WSTreeModel);
        toDisplay = WSTreeModel.getRoot();

        jTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object o = jTree.getLastSelectedPathComponent();
                if (o instanceof SimulateWS) {
                    System.out.println("WS!!");
                    toDisplay = o;
                    createRightPane(rightWindowComponent);
                    refreshRightPane();
                } else if ((e.getClickCount() == 2)&&(o instanceof SimulateWP)) {
                    toDisplay = o;
                    createRightPane(rightWindowComponent);
                   refreshRightPane();
                    
                    
                }
            }
        });
       

        container.add(jTree);
        panel.add(container);
    }

    @Override
    public void createRightPane(JPanel panel) {
    
        panel.setPreferredSize(new Dimension(390, 500));
        if (panel.getComponents().length == 0) {
            if (toDisplay instanceof SimulateWS) {
                panel.add(createWSPane((SimulateWS) toDisplay));
                
                
            } else {
                panel.add(createWPPane((SimulateWP) toDisplay));
                ValidWindow VW=new ValidWindow(panel);
            	VW.createWindow();
                VW.openWindow();
            }
        } else {
            if (toDisplay instanceof SimulateWS) {
                panel.remove(0);
               
                
            } else {
            	
                panel.add(createWPPane((SimulateWP) toDisplay));
                ValidWindow VW=new ValidWindow(panel);
            	VW.createWindow();
                VW.openWindow();
                panel.remove(0);
            }
        }
    }

    
    
     JComponent createWSPane(SimulateWS toDisplay) {
        return new JTextArea("WS");
     }

   
    JComponent createWPPane(SimulateWP toDisplay) {
        return new JTextArea("WP");
    }
}
