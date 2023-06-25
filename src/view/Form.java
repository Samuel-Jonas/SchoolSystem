package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Form extends JPanel{
    private JTextField firstNameField;
    private JTextField lastNameField;

    private JButton addButton;
    private JButton viewButton;

    public Form() {
        JLabel firsNameLabel = new JLabel("Login: ");
        JLabel lastNameLabel = new JLabel("Senha: ");

        firstNameField = new JTextField(25);
        lastNameField = new JTextField(25);

        addButton = new JButton("+");
        addButton.setPreferredSize(new Dimension(278, 40));

        viewButton = new JButton("Ver todos");
        viewButton.setPreferredSize(new Dimension(278, 40));

        Insets fieldsInset = new Insets(0, 0, 10, 0);
        Insets buttonInset = new Insets(20, 0, 0, 0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(firsNameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(firstNameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(lastNameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(lastNameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);
    }

    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public void subimitUsers(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewUsers(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    public void reset(boolean bln) {
        if(bln) {
            firstNameField.setText("");
            lastNameField.setText("");
        }
    }
}
