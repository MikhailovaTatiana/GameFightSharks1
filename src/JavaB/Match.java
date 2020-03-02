package JavaB;

import java.sql.SQLException;

public class Match {

    private Figures figures = new Figures();

    public Match() throws SQLException {

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

        if (figures.getBlackTeam().isEmpty() && figures.getWhiteTeam().isEmpty()) {
            System.out.println("The match has ended in a draw!");
        } else if (figures.getBlackTeam().isEmpty()) {
            System.out.println("\nWHITE TEAM has won! Our congradulations!!!");
        } else {
            System.out.println("\nBLACK TEAM has won! Our congradulations!!!");
        }
    }

    private void gameLogic() throws SQLException {
        int whiteWeapon = Weapon.weaponSelect();
        System.out.println("The White Shark has got the " + Weapon.getName() + " (+" + whiteWeapon + " to its power in the first fight)\n");
        DatabaseConnection.insertWeapon(); // Insert
        int blackWeapon = Weapon.weaponSelect();
        System.out.println("The Black Shark has got the " + Weapon.getName() + " (+" + blackWeapon + " to its power in the first fight)\n");
        DatabaseConnection.insertWeapon(); // Insert
        FightRound fightMatchRest = new FightRound(Figures.getWhiteShark(), Figures.getBlackShark(), whiteWeapon, blackWeapon);
        fightMatchRest.fight();
        figures.removeLoser();
    }
}
