package ihm;

import java.awt.*;

import javax.swing.*;

/**
 * Abstract class which should be use by AddUserWindow, AddWSWindow, AddWPWindow, AddOrgWindow, and ConnexionWindow.
 * That class provide two buttons (describes in lower class) and a panel to fill.
 */
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

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        createWindowPane(windowPane);
    }

    /**
     * Create the "validate" button, which describe the actions to do when the user want to validate informations.
     * @param button button to modify.
     */
    abstract void createValidateButton(JButton button);

    /**
     * Create "cancel" button, which describe the actions to do when the user want to cancel.
     * @param button button to modify
     */
    abstract void createCancelButton(JButton button);

    /**
     * Create the window.
     * @param panel panel to fill.
     */
    abstract void createWindowPane(JPanel panel);
}
