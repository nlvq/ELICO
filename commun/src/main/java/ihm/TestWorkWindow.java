package ihm;

import java.awt.*;

import javax.swing.*;

public class TestWorkWindow extends AbstractWorkPaneWindow {
    @Override
    void createLeftPane(JPanel panel) {
        panel.setPreferredSize(panel.getMaximumSize());
        panel.setBackground(Color.BLUE);
    }

    @Override
    void createRightPane(JPanel panel) {
        panel.setPreferredSize(panel.getMaximumSize());
        panel.setBackground(Color.RED);
    }

    @Override
    void createButtonPane(JPanel panel) {
        panel.add(new JButton("?"));
    }
}
