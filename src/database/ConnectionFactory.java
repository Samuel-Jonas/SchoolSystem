package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    public static Connection getCon() {

        if(connection == null){
            String user = "root";
            String password = "LOSfro@#33";
            String database = "system_school";
            String url = "jdbc:mysql://localhost/"+ database;

            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("Ocorreu um erro no banco de dados");
            }
        }

        return connection;
    }

    public static void close()  {
        try {

            if(connection != null && !connection.isClosed()){
                connection.close();
                connection = null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("There was an error while closing the application connection.");
        }
    }

}