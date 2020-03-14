package JUnitTests;

import JavaB.Histories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class HistoriesTest {

    @BeforeEach
    void setUp() throws SQLException {
        Histories.getLastHistories();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLastHistories() {

    }

    @Test
    void getChoice() {
    }
}