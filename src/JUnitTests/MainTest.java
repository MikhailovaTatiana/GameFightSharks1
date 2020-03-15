package JUnitTests;

import JavaB.DatabaseConnection;
import JavaB.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Connection connection;
    PreparedStatement statement = null;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
    }

    @Test
    public void closeStatementShouldCloseStatement() throws SQLException {
        connection.createStatement();
        DatabaseConnection.getClose();
        assertTrue(statement.isClosed());
    }
}