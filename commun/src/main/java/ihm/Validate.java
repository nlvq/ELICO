package ihm;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;

import main.ContextUtil;
import dao.WorkPackage;
import dao.WorkSpace;

public abstract class Validate extends AbstractWorkPaneWindow {

	public Validate() {
	}

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
		final JTree jTree = new JTree();

		WSTreeNode WSTreeModel = new WSTreeNode(ContextUtil.getRH().findUser("admin").get(0));
		jTree.setModel(WSTreeModel);
		toDisplay = WSTreeModel.getRoot();

		jTree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = jTree.getLastSelectedPathComponent();
				if (o instanceof WorkSpace) {
					toDisplay = o;
					createRightPane(rightWindowComponent);
					refreshRightPane();
				} else if ((e.getClickCount() == 2) && (o instanceof WorkPackage)) {
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

			if (toDisplay instanceof WorkSpace) {
				panel.add(createWSPane((WorkSpace) toDisplay));

			} else {

				panel.add(createWPPane((WorkPackage) toDisplay));
				ValidWindow VW = new ValidWindow(panel);
				VW.createWindow();
				VW.openWindow();
			}
		} else {
			if (toDisplay instanceof WorkSpace) {
				panel.remove(0);

			} else {

				panel.add(createWPPane((WorkPackage) toDisplay));
				ValidWindow VW = new ValidWindow(panel);
				VW.createWindow();
				VW.openWindow();
				panel.remove(0);
			}
		}
	}

	JComponent createWSPane(WorkSpace toDisplay) {
		return new JTextArea("WS");
	}

	JComponent createWPPane(WorkPackage toDisplay) {
		return new JTextArea("WP");
	}
}
