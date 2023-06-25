package database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.ConnectionFactory;
import entity.User;

public class UserDAO {
    
    ArrayList<User> listUser = new ArrayList<>();

    public void addUser(User user) {
        Connection con = ConnectionFactory.getCon();

        String query = "INSERT INTO User (firstName, password, creationDate)  VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = con.prepareStatement(query);

            if (user.getFirstName().isEmpty() || user.getPasswordString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Existem campos vazios");
            } else {
                stmt.setString(1, user.getFirstName());
                stmt.setString(2, user.getPasswordString());
                stmt.setString(3, LocalDateTime.now().toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inserir o usuário");
        } finally {
            ConnectionFactory.close();
        }
    }

    public void updateUser(User user) {
        Connection con = ConnectionFactory.getCon();
        String sql = "UPDATE User SET firstName = ?, password = ?, creationDate = ? WHERE id = ?";

        try {

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, user.getFirstName());
           stmt.setString(2, user.getPasswordString());
           stmt.setString(3, user.getCreationDate());
           stmt.setLong(4, user.getId());
           stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazero update");
        } finally{
            ConnectionFactory.close();
        }
    }

    public ArrayList<User> listUser() {

        Connection con = ConnectionFactory.getCon();

        String sql = "SELECT * FROM User";
        try {

           PreparedStatement stmt = con.prepareStatement(sql);

           ResultSet query = stmt.executeQuery();

           while(query.next()){

            int id = query.getInt("id");
            String firstName = query.getString("firstName");
            String password = query.getString("password");
            String creationDate = query.getDate("creationDate").toString();

            User user = new User(id, firstName, password, creationDate);
            user.setId(id);
            listUser.add(user);
           }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao exibir os usuários");
        } finally {
            ConnectionFactory.close();
        }
        return listUser;
    }

    public void delete(int id) {

        Connection con = ConnectionFactory.getCon();
        String sql = "DELETE FROM User WHERE id = " + id;

        try {

           PreparedStatement stmt = con.prepareStatement(sql);

           stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível deletar o usuário com identificador: " + id);
        } finally{
            ConnectionFactory.close();
        }
    }
}
