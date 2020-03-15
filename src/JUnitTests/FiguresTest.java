package JUnitTests;

import JavaB.Figures;
import JavaB.Skills;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FiguresTest {

    private Skills skills;
    private Skills skills1;
    private Skills skills2;


    @BeforeEach
    void setUp() {
        skills = new Skills(2, 134, 13, 5);
        skills1 = new Skills(3, 112, 15,4);
        skills2 = new Skills(1, 158, 9, 2);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void setNumberShark() {
        int number = Figures.setNumberShark(5);
        assertSame(number, Figures.setNumberShark(number));
    }

    @Test
    void getWhiteShark() {
        assertNotNull(skills1);
    }

    @Test
    void getBlackShark() {
        assertNotSame(skills2, skills);
    }

    @Test
    void getWhiteTeam() {
        Figures.setNumberShark(3);
        ArrayList<Skills> whiteTeam = Figures.getTeamCreation();
        ArrayList<Skills> actual = new ArrayList<>();
        actual.add(skills);
        actual.add(skills1);
        actual.add(skills2);
        assertEquals(whiteTeam.size(), actual.size());
    }

    @Test
    void getBlackTeam() {
        Figures.setNumberShark(5);
        ArrayList<Skills> blackTeam = Figures.getTeamCreation();
        assertNull(blackTeam.get(1).name);
    }

    @Test
    void matchStart() {
    }

    @Test
    void white() {
    }

    @Test
    void black() {
    }

    @Test
    void removeLoser() {
    }
}