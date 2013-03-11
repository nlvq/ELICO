package ihm;

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

import dao.Objet;
import dao.WorkPackage;
import dao.WorkSpace;

/**
 * Display a window that allow to add a new WP.
 */
public class AddWPWindow extends AbstractValidateCancelWindow {
    WorkSpace ws;

    JTextField nameField;
    JList<Objet> listObj;
    private JTextField searchField;
    private JList<Objet> searchResult;

    /**
     * Constructor
     * @param ws WS in which we add the WP
     */
    public AddWPWindow(WorkSpace ws) {
        this.ws = ws;
    }

    @Override
    void createValidateButton(JButton button) {
        button.setText("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Objet> objects = new ArrayList<>();
                for (int i = 0; i < listObj.getModel().getSize(); i++) {
                    objects.add(listObj.getModel().getElementAt(i));
                }
                WorkPackage wp = new WorkPackage();
                wp.setTitle(nameField.getText());
                wp.setObjets(objects);
                ws.getChilds().add(ws);
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
            	  // TODO ajouter une méthode permettant de chercher un WP par son nom.
                //searchResult.setListData(ContextUtil.getWorkPackage().findWP(wp)
                //SimulateWP.search(searchField.getText()));
            	  throw new UnsupportedOperationException();
            }
        });

        listObj.setModel(new DefaultListModel<Objet>());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((DefaultListModel<Objet>) listObj.getModel()).addElement(searchResult.getSelectedValue());
            }
        });
    }
}
