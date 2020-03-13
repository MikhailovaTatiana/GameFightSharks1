package JUnitTests;

import JavaB.DatabaseConnection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    private static DatabaseConnection instance;

    @BeforeEach
    void setUp() throws SQLException {
        DatabaseConnection.getInstance();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getConnection() {
        assertNotNull(instance.getConnection());
    }

    @Test
    void getInstance() {
        assertNotNull(instance);
    }

    @Test
    void insertShark() {
    }

    @Test
    void insertWhiteShark() {
    }

    @Test
    void insertBlackShark() {
    }

    @Test
    void insertWeapon() {
    }
}