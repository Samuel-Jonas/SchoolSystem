package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserDetails extends JPanel{
    
    private JTable userTable;
    
    private String[] userTableColumn = {"Primeiro nome", "Último nome"};

    private JButton backButton;

    public UserDetails() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JToolBar toolBar = new JToolBar();
        userTable = new JTable();
        JScrollPane userTableScroll = new JScrollPane(userTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Voltar");
        add(toolBar);
        toolBar.add(backButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }

    public void getUsers(Object[] objects) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) userTable.getModel();
        defaultTableModel.setColumnIdentifiers(userTableColumn);
        int i = 0;
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}
