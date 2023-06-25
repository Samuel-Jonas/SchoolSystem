package database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.ConnectionFactory;
import model.Student;

public class StudentDAO {
    
    ArrayList<Student> studantList = new ArrayList<Student>();

    public void Save (Student student) {
        Connection connection = ConnectionFactory.getCon();

        String query = "INSERT INTO Student (name, age, address, paymentStatus, creationDate, grade) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement statement = connection.prepareStatement(query);

            if (student.getNome().isEmpty() || String.valueOf(student.getIdade()).isEmpty() 
                || String.valueOf(student.getNota()).isEmpty() ||student.getEndereco().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Existem campos vazios");
            } else {
                statement.setString(1, student.getNome());
                statement.setInt(2, student.getIdade());
                statement.setDouble(3, student.getNota());
                statement.setString(4, student.getEndereco());
                statement.execute();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.close();
        }
    }

    public void Update(Student student) {

        Connection con = ConnectionFactory.getCon();
        String sql = "UPDATE Studant SET name = ?, age = ?, grade = ?, address = ? WHERE id = ?";

        try {

           PreparedStatement stmt = con.prepareStatement(sql);

           stmt.setString(1, student.getNome());
           stmt.setInt(2, student.getIdade());
           stmt.setDouble(3, student.getNota());
           stmt.setString(4, student.getEndereco());
           stmt.setLong(6, student.getId());

           stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazero update");
        } finally{
            ConnectionFactory.close();
        }
    }

    public ArrayList<Student> GetStudentList() {

        Connection con = ConnectionFactory.getCon();

        String sql = "SELECT * FROM Student";
        try {
           
           PreparedStatement stmt = con.prepareStatement(sql);

           ResultSet query = stmt.executeQuery();

           while(query.next()){

            int id = query.getInt("id");
            String nome = query.getString("name");
            int idade = query.getInt("age");
            long grade = query.getLong("grade");
            String endereco = query.getString("address");

            Student student = new Student(nome, endereco, idade, grade);
            student.setId(id);
            studantList.add(student);
                
           }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //Fecha apos as operações
            ConnectionFactory.close();
        }
        return studantList;
    }


    //essa funcao so e responsavel por isso, por deletar qualquer coisa que venha pelo parametro!
    public void Delete (int id) {

        //abre a conxao com o banco, "NAO ESQUECER DE CONFIGURAR no CONNECTIONFACTORY.JAVA"
        Connection con = ConnectionFactory.getCon();
        //o codigo sql pra inserir
        String sql = "DELETE FROM Student WHERE ID = " + id;
        try {
            //Trata a string e prapara para ser executada com uma query
           PreparedStatement stmt = con.prepareStatement(sql);
           //seta os valores mapeados no INSERT
           stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //Fecha apos as operações
            ConnectionFactory.close();
        }
    }
}
