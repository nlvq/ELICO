package ihm;

import java.awt.*;

import javax.swing.*;

public class AdminWindow extends AbstractButtonWindow {
    @Override
    public void createWindow() {
        super.createWindow();
        frame.setTitle("Elico - Admin");
    }

    @Override
    void createButtonPane(JPanel panel) {
        JButton plusButton = new JButton("+");
        JButton helpButton = new JButton("?");
        panel.add(plusButton);
        panel.add(helpButton);
    }

    @Override
    void createWindowPane(JPanel panel) {
        panel.setBackground(Color.RED);
    }
}