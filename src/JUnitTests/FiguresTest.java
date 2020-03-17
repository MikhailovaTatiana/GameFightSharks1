package JUnitTests;

import JavaB.Figures;
import JavaB.Skills;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FiguresTest {

    private Skills skills;
    private Skills skills1;
    private Skills skills2;


    @Before
    public void setUp() {
        skills = new Skills(2, 134, 13, 5);
        skills1 = new Skills(3, 112, 15,4);
        skills2 = new Skills(1, 158, 9, 2);
    }

    @Test
    public void setNumberShark() {
        assertSame(5, Figures.setNumberShark(5));
    }

    @Test
    public void getWhiteShark() {
        assertNotNull(skills1);
    }

    @Test
    public void getBlackShark() {
        assertNotSame(skills2, skills);
    }

    @Test
    public void getWhiteTeam() {
        Figures.setNumberShark(3);
        ArrayList<Skills> whiteTeam = Figures.getTeamCreation();
        ArrayList<Skills> actual = new ArrayList<>();
        actual.add(skills);
        actual.add(skills1);
        actual.add(skills2);
        assertEquals(whiteTeam.size(), actual.size());
    }

    @Test
    public void getBlackTeam() {
        Figures.setNumberShark(4);
        ArrayList<Skills> blackTeam = Figures.getTeamCreation();
        assertNull(blackTeam.get(1).name);
    }
}