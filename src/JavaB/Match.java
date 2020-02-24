package JavaB;

public class Match {

    public Match() {

        TeamNumbers teamNumbers = new TeamNumbers();
        teamNumbers.start();
        int num = teamNumbers.getNumbers();

        Figures figures = new Figures();
        figures.setNumberShark(num);
        figures.match();
        Skills wShark = figures.getWhiteShark();
        Skills bShark = figures.getBlackShark();

        Weapon weapon = new Weapon();
        weapon.setNumberWeapon(num);
        System.out.println("Select (with INDEX) one weapon for White Team");
        weapon.weaponList();
        int upgr1 = weapon.getUpgradeWeapon();
        System.out.println("Select one weapon for Black Team");
        weapon.weaponList();
        int upgr2 = weapon.getUpgradeWeapon();

        FightRound fightMatch = new FightRound(wShark, bShark, upgr1, upgr2);
        fightMatch.fight();

        while (!figures.getWhiteTeam().isEmpty() && !figures.getBlackTeam().isEmpty()) {

            System.out.println(figures.getWhiteTeam().size());
            System.out.println(figures.getBlackTeam().size());

            figures.white();
            figures.black();
            wShark = figures.getWhiteShark();
            bShark = figures.getBlackShark();
            FightRound fightMatchRest = new FightRound(wShark, bShark, upgr1, upgr2);
            fightMatchRest.fight();
            figures.sharkLosers();

            System.out.println(figures.getWhiteTeam().size());
            System.out.println(figures.getBlackTeam().size());
        }
        if (figures.getBlackTeam().isEmpty()) {
            System.out.println("\nWHITE TEAM has won! Our congradulations!!!");
        }
        if (figures.getWhiteTeam().isEmpty()) {
            System.out.println("\nBLACK TEAM has won! Our congradulations!!!");
        }
    }
}
