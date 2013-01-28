package fr.umlv.elico.ihm;


import java.awt.*;

import javax.swing.*;

public class TestValidateCancelWindow extends AbstractValidateCancelWindow {
    @Override
    void createValidateButton(JButton button) {
        button.setText("Accept");
    }

    @Override
    void createCancelButton(JButton button) {
        button.setText("Cancel");
    }

    @Override
    void createWindowPane(JPanel panel) {
        panel.setBackground(Color.BLUE);
    }
}
