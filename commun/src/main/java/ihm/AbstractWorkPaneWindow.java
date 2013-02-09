package ihm;

import javax.swing.*;

/**
 * Abstract class which should be use by all user view.
 * All this view uses two panes and a button line.
 * That class provide a button panel and two panels to fill.
 */
public abstract class AbstractWorkPaneWindow extends AbstractButtonWindow {
    JPanel leftWindowComponent;
    JPanel rightWindowComponent;

    @Override
    public void createWindowPane(JPanel panel) {

        leftWindowComponent = new JPanel();
        rightWindowComponent = new JPanel();

        createLeftPane(leftWindowComponent);
        createRightPane(rightWindowComponent);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftWindowComponent, rightWindowComponent);
        splitPane.setDividerLocation(.2);

        panel.add(splitPane);
    }

    void refreshRightPane() {
        rightWindowComponent.revalidate();
    }

    /**
     * Create the leftPane of the window.
     * @param panel panel to fill
     */
    abstract public void createLeftPane(JPanel panel);

    /**
     * Create the right pane of the window.
     * @param panel panel to fill
     */
    abstract public void createRightPane(JPanel panel);
}
