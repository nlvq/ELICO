package ihm;

import java.awt.*;

import javax.swing.*;

public class TestTreeWindow extends AbstractTreeWindow {

    @Override
    void createButtonPane(JPanel panel) {
        panel.add(new JButton("?"));
    }
}
