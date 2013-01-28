package fr.umlv.elico.ihm;

import java.awt.*;
import java.util.Objects;

import javax.swing.*;

public abstract class AbstractWindow implements IWindow {
    JFrame frame;

    @Override
    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("Elico");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void openWindow() {
        Objects.requireNonNull(frame);
        frame.setVisible(true);
    }

    @Override
    public void closeWindow() {
        frame.dispose();
    }
}
