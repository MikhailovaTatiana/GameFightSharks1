package JavaB;

public class Match {

    public Match() {

        TeamNumbers teamNumbers = new TeamNumbers();
        teamNumbers.start();

        Figures figures = new Figures();
        figures.setNumberShark(teamNumbers.getNumbers());
        figures.match();

        FightRound fightMatch = new FightRound(figures.getWhiteShark(), figures.getBlackShark(), Weapon.weaponSelect(), Weapon.weaponSelect());
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
