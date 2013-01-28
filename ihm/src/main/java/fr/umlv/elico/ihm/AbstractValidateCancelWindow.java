package fr.umlv.elico.ihm;

import java.awt.*;

import javax.swing.*;

public abstract class AbstractValidateCancelWindow extends AbstractWindow {
    JButton validateButton;
    JButton cancelButton;
    JPanel windowPane;

    @Override
    public void createWindow() {
        super.createWindow();
        frame.setLayout(new BorderLayout());

        JPanel buttonPane = new JPanel(null);
        BoxLayout layout = new BoxLayout(buttonPane, BoxLayout.X_AXIS);
        buttonPane.setLayout(layout);

        cancelButton = new JButton();
        validateButton = new JButton();

        createCancelButton(cancelButton);
        createValidateButton(validateButton);

        buttonPane.add(cancelButton);
        buttonPane.add(validateButton);

        windowPane = new JPanel();

        frame.getContentPane().add(buttonPane, BorderLayout.SOUTH);
        frame.getContentPane().add(windowPane, BorderLayout.CENTER);

        createWindowPane(windowPane);
    }

    abstract void createValidateButton(JButton button);
    abstract void createCancelButton(JButton button);
    abstract void createWindowPane(JPanel panel);
}
