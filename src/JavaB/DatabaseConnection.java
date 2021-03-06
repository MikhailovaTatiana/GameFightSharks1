package JavaB;

import java.sql.*;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private static Connection connection = null;
    public static int lastMatchID;

    public static String getPassword(String password) {
        return password;
    }

    private DatabaseConnection() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/sharks_fight" + "?serverTimezone=UTC";
            String username = "student";
            connection = DriverManager.getConnection(url, username, getPassword("test123"));
            System.out.println("\nConnection succeeded!");
        } catch(Exception e){
            e.printStackTrace();
        }
        lastMatchID = matchNumber();
    }

    public static boolean dbClose() throws SQLException {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private static int matchNumber() throws SQLException {
        PreparedStatement matchID = connection.prepareStatement("SELECT match_id FROM matches order by match_id desc LIMIT 1");
        ResultSet rs = matchID.executeQuery();
        int id = 0;
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id + 1;
    }

    private static int getVictories() throws SQLException {
        PreparedStatement victory = connection.prepareStatement("SELECT victories FROM matches " +
                "where match_id = ? and team_name = ? and shark_number = ?");
        victory.setInt(1, lastMatchID);
        victory.setString(2, "white");
        victory.setInt(3, Figures.getWhiteShark().id);
        ResultSet rs = victory.executeQuery();
        int v = 0;
        while (rs.next()) {
            v = rs.getInt(1);
        }
        return v;
    }

    public static void insertWhiteSharks() throws SQLException {
        PreparedStatement insertWhiteShark = connection.prepareStatement("insert into matches " +
                "(shark_number, shark_life, shark_power, shark_strength, team_name, match_id) values (?, ?, ?, ?, ?, ?)");
        for (int i = 0; i < Figures.getWhiteTeam().size(); i++) {
            insertWhiteShark.setInt(1, Figures.getWhiteTeam().get(i).id);
            insertWhiteShark.setInt(2, Figures.getWhiteTeam().get(i).life);
            insertWhiteShark.setInt(3, Figures.getWhiteTeam().get(i).power);
            insertWhiteShark.setInt(4, Figures.getWhiteTeam().get(i).strength);
            insertWhiteShark.setString(5, "white");
            insertWhiteShark.setInt(6, lastMatchID);
            insertWhiteShark.executeUpdate();
        }
    }

    public static void insertBlackSharks() throws SQLException {
        PreparedStatement insertBlackShark = connection.prepareStatement("insert into matches " +
                "(shark_number, shark_life, shark_power, shark_strength, team_name, match_id) values (?, ?, ?, ?, ?, ?)");
        for (int i = 0; i < Figures.getBlackTeam().size(); i++) {
            insertBlackShark.setInt(1, Figures.getBlackTeam().get(i).id);
            insertBlackShark.setInt(2, Figures.getBlackTeam().get(i).life);
            insertBlackShark.setInt(3, Figures.getBlackTeam().get(i).power);
            insertBlackShark.setInt(4, Figures.getBlackTeam().get(i).strength);
            insertBlackShark.setString(5, "black");
            insertBlackShark.setInt(6, lastMatchID);
            insertBlackShark.executeUpdate();
        }

    }

    public static void setWeaponWhite() throws SQLException {
        PreparedStatement setWeapon = connection.prepareStatement("update matches set weapon_name = ? " +
                "where match_id = ? and team_name = ? and shark_number = ?");
        setWeapon.setString(1, Weapon.getName());
        setWeapon.setInt(2, lastMatchID);
        setWeapon.setString(3, "white");
        setWeapon.setInt(4, Figures.getWhiteShark().id);
        setWeapon.executeUpdate();
    }

    public static void setWeaponBlack() throws SQLException {
        PreparedStatement setWeapon = connection.prepareStatement("update matches set weapon_name = ? " +
                "where match_id = ? and team_name = ? and shark_number = ?");
        setWeapon.setString(1, Weapon.getName());
        setWeapon.setInt(2, lastMatchID);
        setWeapon.setString(3, "black");
        setWeapon.setInt(4, Figures.getBlackShark().id);
        setWeapon.executeUpdate();
    }

    public static void setVictoryWhite() throws SQLException {
        PreparedStatement setVictory = connection.prepareStatement("update matches set victories = ? " +
                "where match_id = ? and team_name = ? and shark_number = ?");
        setVictory.setInt(1, getVictories() + 1);
        setVictory.setInt(2, lastMatchID);
        setVictory.setString(3, "white");
        setVictory.setInt(4, Figures.getWhiteShark().id);
        setVictory.executeUpdate();
    }

    public static void setVictoryBlack() throws SQLException {
        PreparedStatement setVictory = connection.prepareStatement("update matches set victories = ? " +
                "where match_id = ? and team_name = ? and shark_number = ?");
        setVictory.setInt(1, getVictories() + 1);
        setVictory.setInt(2, lastMatchID);
        setVictory.setString(3, "black");
        setVictory.setInt(4, Figures.getWhiteShark().id);
        setVictory.executeUpdate();
    }

    public static void getHistory() throws SQLException {
        PreparedStatement history = connection.prepareStatement("select * from matches where match_id = ?");
        history.setInt(1, Histories.getChoice());
        ResultSet lastHistories = history.executeQuery();
        while(lastHistories.next()){
            System.out.println("match: " + lastHistories.getString("match_id") + ", " +
                    lastHistories.getString("team_name") +
                    " shark " + lastHistories.getString("shark_number") +
                    ", life: " + lastHistories.getString("shark_life") +
                    ", power: " + lastHistories.getString("shark_power") +
                    ", strength: " + lastHistories.getString("shark_strength") +
                    ", with " + lastHistories.getString("weapon_name") +
                    " has won " + lastHistories.getString("victories") + " time/s");
        }
    }
}
