package ihm;

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
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import dao.Objet;
import dao.Utilisateur;
import dao.WorkPackage;
import dao.WorkSpace;

public class IngWindow extends AbstractTreeWindow {
	private Objet selectedObject;
  private WorkPackage selectedWP;
	
	public IngWindow(Utilisateur utilisateur) {
	  super(utilisateur);
  }

	@Override
	public void createWindow() {
		super.createWindow();
		frame.setTitle("Elico-Ingénieur");
	}

	@Override
	void createButtonPane(JPanel panel) {
		JButton acquire = new JButton("A");
		acquire.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedWP != null) {
					// TODO selectedWP.acquire();
				}
			}
		});
		
		JButton publish = new JButton("Pu");
		
		publish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedWP != null) {
					// TODO selectedWP.publish();
				}
			}
		});
		
		JButton promote = new JButton("Pr");
		
		promote.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedWP != null) {
					// TODO selectedWP.promote();
				}
			}
		});
		
		JButton sync = new JButton("S");
		
		sync.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedWP != null) {
					// TODO selectedWP.sync();
				}
			}
		});
		
		JButton help = new JButton("?");
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("help indispo");	
			}
		});

		panel.add(acquire);
		panel.add(publish);
		panel.add(promote);
		panel.add(sync);
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
                  Editor editor = new Editor(jList.getModel().getElementAt(jList.locationToIndex(e.getPoint())));
                  editor.createWindow();
                  editor.openWindow();
              }
          }
      });

      return new JScrollPane(jList);
  }
}
