package JavaB;

public class Match {

    public Match() {

        TeamNumbers teamNumbers = new TeamNumbers();
        teamNumbers.selectNambers();

        Figures figures = new Figures();
        figures.setNumberShark(teamNumbers.getNumbers());
        figures.matchStart();
        int whiteWeapon = Weapon.weaponSelect();
        System.out.println("The White Shark has got the " + Weapon.getName() + " (+" + whiteWeapon + " to its power in the first fight)\n");
        int blackWeapon = Weapon.weaponSelect();
        System.out.println("The Black Shark has got the " + Weapon.getName() + " (+" + blackWeapon + " to its power in the first fight)\n");

        FightRound fightMatch = new FightRound(figures.getWhiteShark(), figures.getBlackShark(), whiteWeapon, blackWeapon);
        fightMatch.fight();

        while (!figures.getWhiteTeam().isEmpty() && !figures.getBlackTeam().isEmpty()) {
            figures.white();
            FightRound fightMatchRest = new FightRound(figures.getWhiteShark(), figures.getBlackShark(), Weapon.weaponSelect(), Weapon.weaponSelect());
            fightMatchRest.fight();
            figures.sharkLosers();
        }
        if (figures.getBlackTeam().isEmpty()) {
            System.out.println("\nWHITE TEAM has won! Our congradulations!!!");
        }
        if (figures.getWhiteTeam().isEmpty()) {
            System.out.println("\nBLACK TEAM has won! Our congradulations!!!");
        }
    }
}
