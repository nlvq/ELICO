package fr.umlv.elico.ihm;

import javax.swing.*;

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

    abstract void createLeftPane(JPanel panel);
    abstract void createRightPane(JPanel panel);
}
