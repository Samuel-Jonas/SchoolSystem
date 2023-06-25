package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;
    private static String sqlFilePath = "src/database/init_db.sql";

    private static String user = "root";
    private static String password = "LOSfro@#33";
    private static String database = "system_school";
    private static String url = "jdbc:mysql://localhost/"+ database;

    public static Connection getCon() {

        if(connection == null){
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

    public static void initDatabase() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath))) {

            StringBuilder sqlStatement = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sqlStatement.append(line);
                if (line.endsWith(";")) {
                    try (PreparedStatement statement = connection.prepareStatement(sqlStatement.toString())) {
                        statement.execute();
                        System.out.println("The database was initialized");
                    }
                    sqlStatement.setLength(0); // Clear the string builder
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}