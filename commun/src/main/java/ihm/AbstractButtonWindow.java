package ihm;

import java.awt.*;

import javax.swing.*;

/**
 * Abstract class which should not be used by any class.
 * That class provide a panel to fill with buttons.
 */
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

    /**
     * Create the panel button.
     * @param panel panel to fill
     */
    abstract void createButtonPane(JPanel panel);

    /**
     * Create the rest of the window.
     * @param panel panel to fill
     */
    abstract void createWindowPane(JPanel panel);
}
