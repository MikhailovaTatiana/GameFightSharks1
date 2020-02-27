package JavaB;

public class Match {

    private Figures figures = new Figures();

    public Match() {

        TeamNumbers teamNumbers = new TeamNumbers();
        teamNumbers.selectNambers();

        figures.setNumberShark(teamNumbers.getNumbers());
        figures.matchStart();
        gameLogic();

        while (!figures.getWhiteTeam().isEmpty() && !figures.getBlackTeam().isEmpty()) {
            figures.white();
            figures.black();
            gameLogic();
        }

        if (figures.getBlackTeam().isEmpty()) {
            System.out.println("\nWHITE TEAM has won! Our congradulations!!!");
        }
        if (figures.getWhiteTeam().isEmpty()) {
            System.out.println("\nBLACK TEAM has won! Our congradulations!!!");
        }
    }

    private void gameLogic() {
        int whiteWeapon = Weapon.weaponSelect();
        System.out.println("The White Shark has got the " + Weapon.getName() + " (+" + whiteWeapon + " to its power in the first fight)\n");
        int blackWeapon = Weapon.weaponSelect();
        System.out.println("The Black Shark has got the " + Weapon.getName() + " (+" + blackWeapon + " to its power in the first fight)\n");
        FightRound fightMatchRest = new FightRound(figures.getWhiteShark(), figures.getBlackShark(), whiteWeapon, blackWeapon);
        fightMatchRest.fight();
        figures.removeLoser();
    }
}
