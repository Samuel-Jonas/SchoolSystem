package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //Variavel privada e estatica que vai ficar a conexao
    private static Connection con;

    //Configuração do banco, e atribuição da conexao para a variavel da linha 10, apos ele retorna a conexao para quem chamou!
    public static Connection getCon() {
        if(con == null){
            String user = "root";
            String password = "LOSfro@#33";
            String database = "system_school";
            String url = "jdbc:mysql://localhost/"+ database;
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("Ocorreu um erro no banco de dados");
            }
        }
        return con;
    }

    //fecha a conexao, não esquecer de chamar a cada operação no banco!
    public static void close()  {
        try {
            if(con != null && !con.isClosed()){
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um erro enquanto o app estava fechando a coenxao.");
        }
    }

}