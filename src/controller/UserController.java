package controller;

import javax.swing.JOptionPane;

import database.repository.UserDAO;
import model.User;
import view.Form;
import view.UserDetails;

public class UserController {
    private Form form;
    private UserDetails userDetails;
    private UserDAO userDAO = new UserDAO();

    public UserController(Form form, UserDetails userDetails) {
        this.form = form;
        this.userDetails = userDetails;

        this.form.subimitUsers(e -> {
            String firstName = this.form.getFirstName();
            String lastName = this.form.getLastName();

            if (firstName.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Insira o login", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (lastName.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Insira a senha", "Erro", JOptionPane.ERROR_MESSAGE);   
                return;
            }

            this.userDAO.addUser(new User(firstName, lastName));
            this.form.reset(true);
        });

        this.form.viewUsers(e -> {
            this.userDetails.getUsers(this.userDAO.listUser().toArray());
        });
    }
    
}
