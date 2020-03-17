package JUnitTests;

import JavaB.Skills;
import JavaB.Weapon;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponTest {

    private Skills skills1;
    private Skills skills2;

    @Before
    public void setUp() {
        skills1 = new Skills("stone", 5);
        skills2 = new Skills("grenade", 15);
    }

    @Test
    public void getName() {
        assertNotNull(skills1.name);
    }

    @Test
    public void weaponSelect() {
        int weapon = Weapon.weaponSelect();
        assertNotSame(skills2.upgrade, weapon);
    }
}