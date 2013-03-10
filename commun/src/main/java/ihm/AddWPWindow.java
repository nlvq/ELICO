package ihm;

import ihm.simulate.SimulateObjet;
import ihm.simulate.SimulateWP;
import ihm.simulate.SimulateWS;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Display a window that allow to add a new WP.
 */
public class AddWPWindow extends AbstractValidateCancelWindow {
    SimulateWS ws;

    private JTextField nameField;
    private JList<SimulateObjet> listObj;
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
                List<SimulateObjet> objects = new ArrayList<>();
                for (int i = 0; i < listObj.getModel().getSize(); i++) {
                    objects.add(listObj.getModel().getElementAt(i));
                }
                ws.addWP(nameField.getText(), objects);
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
