package ihm;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListDataListener;

import ihm.simulate.SimulateObjet;
import ihm.simulate.SimulateWP;
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
    private List<SimulateObjet> objects = new ArrayList<>();

    /**
     * Constructor
     * @param ws WS in which we add the WP
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
                frame.dispose();
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
        JLabel nameText = new JLabel("Name:");
        nameField = new JTextField(60);
        listObj = new JList<>();
        listObj.setPreferredSize(new Dimension(300, 400));
        searchField = new JTextField(30);
        JButton searchButton = new JButton("Search");
        searchResult = new JList<>();
        searchResult.setPreferredSize(new Dimension(200, 100));
        JButton addButton = new JButton("Add");

        panel.add(nameText);
        panel.add(nameField);
        panel.add(listObj);
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(searchResult);
        panel.add(addButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchResult.setListData(SimulateWP.search(searchField.getText()));
            }
        });

        listObj.setModel(new DefaultListModel<SimulateObjet>());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultListModel) listObj.getModel()).addElement(searchResult.getSelectedValue());
            }
        });
    }
}
