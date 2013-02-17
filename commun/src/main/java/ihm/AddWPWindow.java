package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ihm.simulate.SimulateObjet;
import ihm.simulate.SimulateWS;

/**
 * Display a window that allow to add a new WP.
 */
public class AddWPWindow extends AbstractValidateCancelWindow {
    SimulateWS ws;

    JTextField nameField;
    JList<SimulateObjet> listObj;
    private JTextField searchField;
    private JList<SimulateObjet> searchResult;

    /**
     * Constructor
     * @param ws WS in wich we add the WP
     */
    public AddWPWindow(SimulateWS ws) {
        this.ws = ws;
    }

    @Override
    void createValidateButton(JButton button) {
        button.setText("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ws.addWP(nameField.getText(), listObj.getSelectedValuesList());
            }
        });
    }

    @Override
    void createCancelButton(JButton button) {
        button.setText("Cancel");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    @Override
    void createWindowPane(JPanel panel) {
        panel.setLayout(new GridBagLayout());

        JTextArea nameText = new JTextArea("Name:");
        nameField = new JTextField(60);
        JPanel listContainer = new JPanel();
        listObj = new JList<>();
        listContainer.add(listObj);
        searchField = new JTextField(30);
        JButton searchButton = new JButton("Search");
        JPanel searchResultContainer = new JPanel();
        searchResult = new JList<>();
        searchResultContainer.add(searchResult);
        JButton addButton = new JButton("Add");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = gbc.REMAINDER;
        gbc.weightx = 1f;
        gbc.weighty = 1f;
        panel.add(nameText, gbc);

        gbc.gridwidth = gbc.REMAINDER;
        panel.add(nameField, gbc);

        gbc.gridwidth = 2;
        gbc.gridheight = 4;
        panel.add(listContainer, gbc);

        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        panel.add(searchField, gbc);

        gbc.gridwidth = gbc.REMAINDER;
        panel.add(searchButton);

        gbc.gridwidth = gbc.REMAINDER;
        gbc.gridheight = 2;
        panel.add(searchResultContainer);

        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(addButton, gbc);
    }
}
