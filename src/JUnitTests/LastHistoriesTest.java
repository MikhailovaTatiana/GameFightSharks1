package JUnitTests;

import JavaB.LastHistories;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class LastHistoriesTest {

    @BeforeEach
    void setUp() throws SQLException {
        LastHistories.getLastHistories();
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