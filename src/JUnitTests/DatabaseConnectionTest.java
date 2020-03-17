package JUnitTests;

import JavaB.DatabaseConnection;
import org.junit.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private DatabaseConnection databaseConnection;

    @Before
    public void setUp() throws SQLException {
        databaseConnection = DatabaseConnection.getInstance();
    }

    @Test
    public void dbClose() throws SQLException {
        assertTrue(databaseConnection.dbClose());
    }

    @Test
    public void getInstance() throws SQLException {
        assertNotNull(databaseConnection.getInstance());
    }
}