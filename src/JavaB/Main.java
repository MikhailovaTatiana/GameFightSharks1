package JavaB;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        TeamNumbers teamNumbers = new TeamNumbers();
        teamNumbers.start();
        //ändra till getter
        int num = teamNumbers.numbers;

        Figures figures = new Figures();
        figures.numberShark = num;
        figures.selectWhiteSharks();
        figures.selectBlackSharks();
        Skills wShark = figures.whiteShark;
        Skills bShark = figures.blackShark;

        Weapon weapon = new Weapon();
        weapon.numberWeapon = num;
        weapon.weaponList();
        int upgr = weapon.upgradeWeapon;

        FightMatch fightMatch = new FightMatch(wShark, bShark, upgr);
        fightMatch.fight();

        scanner.close();
    }
}
