package JavaB;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        TeamNumbers teamNumbers = new TeamNumbers();
        teamNumbers.start();

        Figures figures = new Figures();
        figures.selectWhiteSharks();
        Skills whiteShark = figures.whiteShark();
        figures.selectBlackSharks();
        Skills blackShark = figures.blackShark();

        Weapon weapon = new Weapon();
        weapon.numberWeapon = figures.numberShark;
        weapon.weaponList();

        FightMatch fightMatch = new FightMatch(whiteShark, blackShark);
        fightMatch.fight();

    }
}