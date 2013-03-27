package ihm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import main.ContextUtil;

import dao.Maturite.Etat;
import dao.Objet;
import dao.WorkPackage;
import dao.WorkSpace;

public class ValidatorWindow extends Validate {
	private static final String deleteString = "Delete";// ************8

	public Objet getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Objet selectedObject) {
		this.selectedObject = selectedObject;
	}

	public WorkPackage getSelectedWP() {
		return selectedWP;
	}

	public void setSelectedWP(WorkPackage selectedWP) {
		this.selectedWP = selectedWP;
	}

	int j;

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
	void createButtonPane(final JPanel panel) {

		A.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] option = { "OK" };
				int n = JOptionPane.showOptionDialog(frame, "Bouton pas encore programme" + ":  Cliquez deux fois sur votre workpackage ", "information ", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, null);
				if (n == 0) {
					;
				}

				/*
				 * // valider le workpackage et tous ses fils
				 * 
				 * // Objet o=new Objet(); // o=selectedObject.getParent();
				 * //o.getMaturite().setTitle(Etat.VALIDED); ArrayList<Objet> list = new
				 * ArrayList<Objet>(); list=(ArrayList<Objet>) selectedWP.getObjets();
				 * // list=(ArrayList<Objet>) o.getChilds(); for(Objet oo : list){
				 * oo.getMaturite().setTitle(Etat.VALIDED); }
				 */

			}
		});

		UN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// frame.dispose();

			}
		});
		help.addActionListener(new ActionListener() {

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
		final List<WorkPackage> wps = ContextUtil.getWorkPackage().getAllWorkPackage();
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
					changeRightPane(jList.getModel().getElementAt(jList.locationToIndex(e.getPoint())));
				} else if (e.getClickCount() == 1) {
					selectedWP = jList.getModel().getElementAt(jList.locationToIndex(e.getPoint()));
					UN.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
							selectedObject.getMaturite().setTitle(Etat.VALIDED);
							jList.removeAll();
							refreshRightPane();

						}
					});
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
			public void mouseClicked(final MouseEvent mouseEvent) {
				if (mouseEvent.getClickCount() == 2) {
					// selectedObject.getMaturite().setTitle(Etat.ASKVALID);
					Object[] options = { "OK", "Verifier" };
					if (selectedObject != null) {
						if (selectedObject.getMaturite().getTitle() == Etat.NUL) {
							CommentValid cmt = new CommentValid(jList.getModel().getElementAt(jList.locationToIndex(mouseEvent.getPoint())));
							cmt.createWindow();
							cmt.openWindow();

						}

						/*
						 * if (selectedObject.getMaturite().getTitle()==Etat.NUL) {Object[]
						 * option = {"OK"}; int n = JOptionPane.showOptionDialog(frame,
						 * "Cet objet n'est pas a valider" , "erreur ",
						 * JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, option,
						 * null); if (n == 0) {;}}
						 */

					}
					if ((selectedObject.getMaturite().getTitle() == Etat.VALIDED) || (selectedObject.getMaturite().getTitle() == Etat.REFUSED)) {
						Object[] option = { "OK" };
						int n = JOptionPane.showOptionDialog(frame, "Cet objet a deja ete valide ou refuse", "erreur ", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, option, null);
						if (n == 0) {
							;
						}
					}

				} else if (mouseEvent.getClickCount() == 1) {
					selectedObject = jList.getModel().getElementAt(jList.locationToIndex(mouseEvent.getPoint()));

				}
			}
		});

		JScrollPane scroll = new JScrollPane(jList);
		scroll.setPreferredSize(new Dimension(765, 490));
		return scroll;
	}

}
