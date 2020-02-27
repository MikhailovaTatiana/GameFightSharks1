package JavaB;

import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection = null;

    DatabaseConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/sakila" + "?serverTimezone=UTC";
            String username = "student";
            String password = "test123";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection succeeded!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            assert connection != null;
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
