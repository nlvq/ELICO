package fr.umlv.elico.ihm;

import java.awt.*;

import javax.swing.*;

public abstract class AbstractButtonWindow extends AbstractWindow {
    JPanel buttonComponent;
    JPanel windowComponent;

    @Override
    public void createWindow() {
        super.createWindow();
        frame.setLayout(new BorderLayout());

        buttonComponent = new JPanel(null);
        buttonComponent.setLayout(new BoxLayout(buttonComponent, BoxLayout.X_AXIS));
        windowComponent = new JPanel();

        frame.getContentPane().add(buttonComponent, BorderLayout.NORTH);
        frame.getContentPane().add(windowComponent, BorderLayout.CENTER);

        createButtonPane(buttonComponent);
        createWindowPane(windowComponent);
    }

    abstract void createButtonPane(JPanel panel);

    abstract void createWindowPane(JPanel panel);
}
