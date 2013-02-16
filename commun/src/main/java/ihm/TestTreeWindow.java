package ihm;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TestTreeWindow extends AbstractTreeWindow {

    @Override
    void createButtonPane(JPanel panel) {
        panel.add(new JButton("?"));
    }
}
