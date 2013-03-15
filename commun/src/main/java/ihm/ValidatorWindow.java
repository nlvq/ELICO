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

import dao.Maturite.Etat;
import dao.Objet;
import dao.WorkPackage;
import dao.WorkSpace;

public class ValidatorWindow extends Validate {

	public ValidatorWindow() {

	}

	@Override
	public void createWindow() {
		super.createWindow();
		frame.setTitle("Elico-validator");
	}

	// private SimulateObjet selectedObject;
	// private SimulateWP selectedWP;
	private Objet selectedObject;
	private WorkPackage selectedWP;

	@Override
	public void createLeftPane(JPanel panel) {
		super.createLeftPane(panel);
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(1200, 500));
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
				// valider tous le workpackage et tout ses fils
				/*
				 * Objet o=new Objet(); o=selectedObject.getParent();
				 * o.getMaturite().setTitle(Etat.VALIDED);
				 * 
				 * //panel.remove (selectedObject); ArrayList<Objet> list = new
				 * ArrayList<Objet>(); list=(ArrayList<Objet>) o.getChilds();
				 * for(Objet oo : list){
				 * oo.getMaturite().setTitle(Etat.VALIDED); panel.lremove(0); }
				 */

			}
		});
		UN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedObject.getMaturite().setTitle(Etat.VALIDED);
				// remove (selectedObject);

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
	JComponent createWSPane(WorkSpace toDisplay) {// (SimulateWS toDisplay)
		/*
		 * final List<SimulateWP> wps = toDisplay.getWorkpackages(); final
		 * JList<SimulateWP> jList = new JList<>(new ListModel<SimulateWP>()
		 */
		// final List<WorkPackage> wps =
		// ContextUtil.getWorkPackage().getAllWorkPackage();

		final List<WorkPackage> wps = toDisplay.getWorkpackages();
		final JList<WorkPackage> jList = new JList<>(
				new ListModel<WorkPackage>() {
					@Override
					public int getSize() {
						return wps.size();
					}

					@Override
					public WorkPackage/* SimulateWP */getElementAt(int index) {
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
						// TODO ?
					}
				});

		jList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					changeRightPane(jList.getModel().getElementAt(
							jList.locationToIndex(e.getPoint())));
				} else if (e.getClickCount() == 1) {
					selectedWP = jList.getModel().getElementAt(
							jList.locationToIndex(e.getPoint()));
				}
			}
		});
		JScrollPane scroll = new JScrollPane(jList);
		scroll.setPreferredSize(new Dimension(765, 490));
		return scroll;

	}

	@Override
	JComponent createWPPane(WorkPackage toDisplay) {
		final List<Objet> objects = toDisplay.getObjets();
		if (objects != null)
			System.out.println("NULLLL");
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
				// TODO ?
			}
		});

		jList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					System.out.println("Open Editor for: "
							+ jList.getModel().getElementAt(
									jList.locationToIndex(e.getPoint())));
					CommentValid cmt = new CommentValid(jList.getModel()
							.getElementAt(jList.locationToIndex(e.getPoint())));
					cmt.createWindow();
					cmt.openWindow();
				} else if (e.getClickCount() == 1) {
					selectedObject = jList.getModel().getElementAt(
							jList.locationToIndex(e.getPoint()));
				}
			}
		});

		JScrollPane scroll = new JScrollPane(jList);
		scroll.setPreferredSize(new Dimension(765, 490));
		return scroll;
	}

}
