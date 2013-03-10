package ihm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import main.ContextUtil;

import sun.util.calendar.CalendarUtils;

import coeur_metier.rh.IRH;
import coeur_metier.rh.RH;
import dao.Utilisateur;
import dao.UtilisateurOrganisationRole;

public class AdminWindow extends AbstractButtonWindow {
    @Override
    public void createWindow() {
        super.createWindow();
        frame.setTitle("Elico - Admin");
    }

    @Override
    void createButtonPane(JPanel panel) {
        JButton plusButton = new JButton("+");
        JButton helpButton = new JButton("?");

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddUserWindow userWindow = new AddUserWindow();
                userWindow.createWindow();
                userWindow.openWindow();
            }
        });

        panel.add(plusButton);
        panel.add(helpButton);
    }

    @Override
    void createWindowPane(JPanel panel) {
        JTable table = new JTable(new AbstractTableModel() {
			private static final long serialVersionUID = 3880937178950100660L;
			private final String[] columnsNames={"First Name", "Last Name","Organisation" ,"Login", "Password", "Phone Number"};

			private IRH rh = ContextUtil.getRH();
	        private List<Utilisateur> users = rh.getAllUser();
            @Override
            public int getRowCount() {
            	users = rh.getAllUser();
                return users.size();
            }

            @Override
            public int getColumnCount() {
                return columnsNames.length;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return columnsNames[columnIndex];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnsNames[columnIndex].getClass();
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
            	users = rh.getAllUser();
                switch (columnIndex) {
                    case 0:
                        return users.get(rowIndex).getFirstName();
                    case 1:
                        return users.get(rowIndex).getLastName();
                    case 2:
                    	StringBuilder sb=new StringBuilder();
                    	sb.append("null");
                        return sb.toString();
                    case 3:
                        return users.get(rowIndex).getLogin();
                    case 4:
                        return users.get(rowIndex).getPassword();
                    default: //case 4:
                        return users.get(rowIndex).getPhoneNumber();
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                throw new UnsupportedOperationException();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
    }
}