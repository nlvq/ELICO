package ihm;

import java.util.Objects;

import javax.swing.JFrame;

/**
 * Default implementation of all windows. The class create a frame which can be use by other interface.
 * No class should extends this class.
 */
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
