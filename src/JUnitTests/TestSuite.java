package JUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DatabaseConnectionTest.class,
        FiguresTest.class,
        WeaponTest.class
})

public class TestSuite {
}
