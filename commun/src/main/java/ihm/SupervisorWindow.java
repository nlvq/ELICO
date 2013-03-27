package ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import dao.Objet;
import dao.Utilisateur;
import dao.WorkPackage;
import dao.WorkSpace;

public class SupervisorWindow extends AbstractTreeWindow {
  	private WorkPackage selectedWP;
  	
  	public SupervisorWindow(Utilisateur user) {
  	  super(user);
    }

    @Override
    void createButtonPane(JPanel panel) {
        JButton A = new JButton("A");
        JButton PU = new JButton("PU");
        JButton PR = new JButton("PR");
        JButton S = new JButton("S");
        JButton WP = new JButton("WP");
        JButton WS = new JButton("WS");
        JButton O = new JButton("O");
        JButton plus = new JButton("+");
        JButton rmWP = new JButton("-WP");
        JButton help = new JButton("?");

        O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrganizationWindow org = new OrganizationWindow();
                org.createWindow();
                if (selectedWP != null) {
                    org.setParent(selectedWP.getWorkSpace().getOrganisation());
                } else {
                		if (toDisplay instanceof WorkPackage) {
                			org.setParent(((WorkPackage) toDisplay).getOrganisation());
                		} else if (toDisplay instanceof WorkSpace) {
                			org.setParent(((WorkSpace) toDisplay).getOrganisation());
                		}
                }
                org.openWindow();
            }
        });

        WP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWPWindow window = null;

                if (selectedWP != null) {
                    window = new AddWPWindow(selectedWP.getWorkSpace());
                } else {
                    window = new AddWPWindow((WorkSpace) toDisplay);
                }
                window.createWindow();
                window.openWindow();
            }
        });

        WS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddWSWindow window = null;

                if (selectedWP != null) {
                    window = new AddWSWindow(selectedWP.getWorkSpace().getOrganisation());
                } else {
                    window = new AddWSWindow(((WorkSpace) toDisplay).getOrganisation());
                }
                window.createWindow();
                window.openWindow();
            }
        });

        rmWP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Oui",
                        "Non"};
                if (selectedWP != null) {
                    int n = JOptionPane.showOptionDialog(frame,
                        "Voulez vous supprimer le WP " + selectedWP.getTitle() + " ?",
                        "Suppression du WP",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        null);

                    if (n == 0) {
                      	throw new UnsupportedOperationException();
                    	  // TODO Create a methode to remove a WP.
                        //selectedWP.getWorkSpace().removeWP(selectedWP);
                        //refreshRightPane();
                    }
                }
            }
        });

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WorkPackage wp;
            	
            	  if (selectedWP != null) {
                    wp = selectedWP;
                } else if (toDisplay instanceof WorkPackage) {
                	  wp = (WorkPackage) toDisplay;
                } else {
                	  wp = ((WorkSpace) toDisplay).getWorkpackages().get(0);
                }
                
                AddWPUserWindow window = new AddWPUserWindow(wp);
                window.createWindow();
                window.openWindow();
            }
        });

        panel.add(A);
        panel.add(PU);
        panel.add(PR);
        panel.add(S);

        panel.add(WP);
        panel.add(WS);
        panel.add(O);
        panel.add(plus);
        panel.add(rmWP);

        panel.add(help);
    }

    @Override
    JComponent createWSPane(WorkSpace toDisplay) {
        final List<WorkPackage> wps = toDisplay.getWorkpackages();
        final JList<WorkPackage> jList = new JList<>(new ListModel<WorkPackage>() {
            @Override
            public int getSize() {
                return wps.size();
            }

            @Override
            public WorkPackage getElementAt(int index) {
                return wps.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
                // TODO ?
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

        return new JScrollPane(jList);
    }

    @Override
    JComponent createWPPane(WorkPackage toDisplay) {
        final List<Objet> objects = toDisplay.getObjets();
        final JList<Objet> jList = new JList<>(new ListModel<Objet>() {
            @Override
            public int getSize() {
                return objects.size();
            }

            @Override
            public Objet getElementAt(int index) {
                return objects.get(index);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
                // TODO ?
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
                }
            }
        });

        return new JScrollPane(jList);
    }
}
