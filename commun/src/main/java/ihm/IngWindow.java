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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
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
