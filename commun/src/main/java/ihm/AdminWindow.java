package ihm;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import ihm.simulate.SimulateRH;
import ihm.simulate.SimulateUser;

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
        panel.add(plusButton);
        panel.add(helpButton);
    }

    @Override
    void createWindowPane(JPanel panel) {
        SimulateRH rh = new SimulateRH();
        final List<SimulateUser> users = rh.getAllUsers();

        JTable table = new JTable(new AbstractTableModel() {
            private final String[] columnsNames={"First Name", "Last Name", "Login", "Password", "Phone Number"};

            @Override
            public int getRowCount() {
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
                switch (columnIndex) {
                    case 0:
                        return users.get(rowIndex).getFirstName();
                    case 1:
                        return users.get(rowIndex).getLastName();
                    case 2:
                        return users.get(rowIndex).getLogin();
                    case 3:
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