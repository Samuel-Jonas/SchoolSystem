package database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.ConnectionFactory;
import entity.Teacher;

// Esta classe prcisa implementar um CRUD
public class TeacherDAO {

    ArrayList<Teacher> listaProf = new ArrayList<Teacher>();

    //este metodo insere no banco os dados do objeto passado por parametro
    public void inserir(Teacher professor) {

        //abre a conxao com o banco, "NAO ESQUECER DE CONFIGURAR no CONNECTIONFACTORY.JAVA"
        Connection con = ConnectionFactory.getCon();
        //o codigo sql pra inserir
        String sql = "INSERT INTO professor (nome, idade, salario, endereco, formacao) VALUES(?, ?, ?, ?, ?)";
        try {
           //Trata a string e prapara para ser executada com uma query
           PreparedStatement stmt = con.prepareStatement(sql);
           
           if(professor.getNome().isEmpty() || String.valueOf(professor.getIdade()).isEmpty() ||
                String.valueOf(professor.getSalario()).isEmpty() || professor.getEndereco().isEmpty() || professor.getFormacao().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Existem campos vazios");
                return;
            }else{

            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setDouble(3, professor.getSalario());
            stmt.setString(4, professor.getEndereco());
            stmt.setString(5, professor.getFormacao());
            stmt.execute();

           }
           
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //Fecha apos as operações
            ConnectionFactory.close();
        }
    }

    public void atualizar(Teacher professor) {
        Connection con = ConnectionFactory.getCon();
        String sql = "UPDATE professor SET nome = ?, idade = ?, salario = ?, endereco = ?, formacao = ? WHERE id = ?";

        try {

           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, professor.getNome());
           stmt.setInt(2, professor.getIdade());
           stmt.setDouble(3, professor.getSalario());
           stmt.setString(4, professor.getEndereco());
           stmt.setString(5, professor.getFormacao());
           stmt.setInt(6, professor.getId());
           stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao fazero update");
        } finally{
            ConnectionFactory.close();
        }
    }

    public ArrayList<Teacher> listar() {

        //abre a conxao com o banco, "NAO ESQUECER DE CONFIGURAR no CONNECTIONFACTORY.JAVA"
        Connection con = ConnectionFactory.getCon();
        //o codigo sql pra inserir
        String sql = "SELECT * FROM professor";
        try {
            //Trata a string e prapara para ser executada com uma query
           PreparedStatement stmt = con.prepareStatement(sql);

           ResultSet query = stmt.executeQuery();

           while(query.next()){

            int id = query.getInt("id");
            String nome = query.getString("nome");
            int idade = query.getInt("idade");
            Double salario = query.getDouble("salario");
            String formacao = query.getString("formacao");
            String endereco = query.getString("endereco");

            Teacher prof = new Teacher(nome, idade, salario, formacao, endereco);
            prof.setId(id);
            listaProf.add(prof);
                
           }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            //Fecha apos as operações
            ConnectionFactory.close();
        }
        return listaProf;
    }


    //essa funcao so e responsavel por isso, por deletar qualquer coisa que venha pelo parametro!
    public void remover(int id) {

        //abre a conxao com o banco, "NAO ESQUECER DE CONFIGURAR no CONNECTIONFACTORY.JAVA"
        Connection con = ConnectionFactory.getCon();
        //o codigo sql pra inserir
        String sql = "DELETE FROM professor WHERE ID = " + id;
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
