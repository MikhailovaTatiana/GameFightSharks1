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
        figures.match();
        Skills wShark = figures.whiteShark;
        Skills bShark = figures.blackShark;

        Weapon weapon = new Weapon();
        weapon.setNumberWeapon(num);
        weapon.weaponList();
        int upgr = weapon.getUpgradeWeapon();

        FightRound fightMatch = new FightRound(wShark, bShark, upgr);
        fightMatch.fight();

        for (int i = 0; i < num-1; i++) {
            figures.white();
            figures.black();
            wShark = figures.whiteShark;
            bShark = figures.blackShark;
            FightRound fightMatchRest = new FightRound(wShark, bShark, upgr);
            fightMatchRest.fight();
        }

        scanner.close();
    }
}
