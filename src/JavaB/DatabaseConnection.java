package JavaB;

import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private static Connection connection;
    //private Connection connection = null;

    private DatabaseConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/sharks_fight" + "?serverTimezone=UTC";
            String username = "student";
            String password = "test123";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("\nConnection succeeded!");
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            assert connection != null;
            //connection.close();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    public static void getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
    }

    public static void insertWeapon() throws SQLException {
        PreparedStatement insertWeapon = connection.prepareStatement("insert into sharks (shark_weapon) value (?)");
        insertWeapon.setString(1, Weapon.getName());
        int rows = insertWeapon.executeUpdate();
    }
}
