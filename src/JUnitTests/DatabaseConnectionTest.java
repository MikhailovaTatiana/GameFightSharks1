package JUnitTests;

import JavaB.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @BeforeEach
    void setUp() throws SQLException {
        DatabaseConnection.getInstance();
    }

    @AfterEach
    void tearDown() throws SQLException {
        DatabaseConnection.getClose();
    }

    @Test
    void getClose() {
    }

    @Test
    void getConnection() {
    }

    @Test
    void getInstance() throws SQLException {
        assertNotNull(DatabaseConnection.getInstance());
    }

    @Test
    void insertWhiteSharks() {
    }

    @Test
    void insertBlackSharks() {
    }

    @Test
    void setWeaponWhite() {
    }

    @Test
    void setWeaponBlack() {
    }

    @Test
    void setVictoryWhite() {
    }

    @Test
    void setVictoryBlack() {
    }

    @Test
    void getHistory() {
    }
}