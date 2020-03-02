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

    Connection getConnection() {
        return connection;
    }

    public static void getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
    }

    static void insertWhiteShark() throws SQLException {
        PreparedStatement insertWhiteShark = connection.prepareStatement("insert into sharks " +
                "(shark_number, shark_life, shark_power, shark_strength, team_name, last_update) values (?, ?, ?, ?, ?, CURDATE())");
        insertWhiteShark.setInt(1, Figures.getWhiteShark().id);
        insertWhiteShark.setInt(2, Figures.getWhiteShark().life);
        insertWhiteShark.setInt(3, Figures.getWhiteShark().power);
        insertWhiteShark.setInt(4, Figures.getWhiteShark().strength);
        insertWhiteShark.setString(5, "White");
        insertWhiteShark.executeUpdate();
    }

    static void insertBlackShark() throws SQLException {
        PreparedStatement insertBlackShark = connection.prepareStatement("insert into sharks " +
                "(shark_number, shark_life, shark_power, shark_strength, team_name, last_update) values (?, ?, ?, ?, ?, CURDATE())");
        insertBlackShark.setInt(1, Figures.getBlackShark().id);
        insertBlackShark.setInt(2, Figures.getBlackShark().life);
        insertBlackShark.setInt(3, Figures.getBlackShark().power);
        insertBlackShark.setInt(4, Figures.getBlackShark().strength);
        insertBlackShark.setString(5, "Black");
        insertBlackShark.executeUpdate();
    }

    public static void insertWeapon() throws SQLException {
        PreparedStatement insertWeapon = connection.prepareStatement("insert into sharks (shark_weapon) value (?)");
        insertWeapon.setString(1, Weapon.getName());
        insertWeapon.executeUpdate();
    }
}
