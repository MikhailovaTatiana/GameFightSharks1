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

        while (!Figures.getWhiteTeam().isEmpty() && !Figures.getBlackTeam().isEmpty()) {
            figures.white();
            figures.black();
            gameLogic();
        }

        if (Figures.getBlackTeam().isEmpty() && Figures.getWhiteTeam().isEmpty()) {
            System.out.println("The match has ended in a draw!");
        } else if (Figures.getBlackTeam().isEmpty()) {
            System.out.println("\nWHITE TEAM has won! Our congradulations!!!");
        } else {
            System.out.println("\nBLACK TEAM has won! Our congradulations!!!");
        }
    }

    private void gameLogic() throws SQLException {
        int whiteWeapon = Weapon.weaponSelect();
        System.out.println("The White Shark has got the " + Weapon.getName() + " (+" + whiteWeapon + " to its power in the fight)\n");
        DatabaseConnection.setWeaponWhite();
        int blackWeapon = Weapon.weaponSelect();
        System.out.println("The Black Shark has got the " + Weapon.getName() + " (+" + blackWeapon + " to its power in the fight)\n");
        DatabaseConnection.setWeaponBlack();
        FightRound fightMatchRest = new FightRound(Figures.getWhiteShark(), Figures.getBlackShark(), whiteWeapon, blackWeapon);
        fightMatchRest.fight();
            if (Figures.getWhiteShark().life > 1 && Figures.getBlackShark().life < 1) {
                DatabaseConnection.setVictoryWhite();
            } else if (Figures.getWhiteShark().life < 1 && Figures.getBlackShark().life > 1) {
                DatabaseConnection.setVictoryBlack();
            }
        figures.removeLoser();
    }
}
