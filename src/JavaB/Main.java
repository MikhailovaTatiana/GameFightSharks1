package JavaB;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        TeamNumbers teamNumbers = new TeamNumbers();
        teamNumbers.start();
        int num = teamNumbers.getNumbers();

        Figures figures = new Figures();
        figures.setNumberShark(num);
        figures.selectWhiteShark();
        figures.selectBlackShark();
        Skills wShark = figures.whiteShark;
        Skills bShark = figures.blackShark;

        Weapon weapon = new Weapon();
        weapon.setNumberWeapon(num);
        weapon.weaponList();
        int upgr = weapon.getUpgradeWeapon();

        FightRound fightMatch = new FightRound(wShark, bShark, upgr);
        fightMatch.fight();

        scanner.close();
    }
}
