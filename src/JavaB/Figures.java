package JavaB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Figures {

    private int numberShark;
    private static Skills whiteShark;
    private static Skills blackShark;

    private int lifeRandom;
    private int powerRandom;
    private int strengthRandom;

    private int opponent;
    private int opponentWhite;
    private int opponentBlack;
    private ArrayList<Skills> sharksList;
    private static ArrayList<Skills> whiteTeam;
    private static ArrayList<Skills> blackTeam;

    public void setNumberShark(int numberShark) {
        this.numberShark = numberShark;
    }

    public static Skills getWhiteShark() {
        return whiteShark;
    }

    public static Skills getBlackShark() {
        return blackShark;
    }

    public ArrayList<Skills> getWhiteTeam() {
        return whiteTeam;
    }

    public ArrayList<Skills> getBlackTeam() {
        return blackTeam;
    }

    //public Figures() {}

    private void selectTeam() {
        sharksList = new ArrayList<>(numberShark);
        for (int i = 0; i < numberShark; i++) {
            random();
            int idShark = i + 1;
            Skills shark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
            sharksList.add(i, shark);
        }
    }

    public void matchStart() throws SQLException {
        selectTeam();
        whiteTeam = sharksList;
        white();
        selectTeam();
        blackTeam = sharksList;
        black();
    }

    public void white() throws SQLException {
        System.out.println("\nWHITE SHARKS TEAM:");
        int x = 1;
            for (Skills rest : whiteTeam) {
                System.out.println("Shark " + rest.id + ": life " + rest.life + ", power " + rest.power + ", strength " + rest.strength + " (index " + x + ")");
                whiteShark = whiteTeam.get(x - 1);
                DatabaseConnection.insertWhiteShark();
                x++;
            }
        selectOpponent();
        if (opponent > whiteTeam.size() - 1 || opponent < 0) {
            System.out.println("Wrong choice! Try again!");
            selectOpponent();
        }
        whiteShark = whiteTeam.get(opponent);
        opponentWhite = opponent;
        System.out.println("You have chosen: White Shark " + whiteShark.id);
    }

    public void black() throws SQLException {
        System.out.println("\nBLACK SHARKS TEAM:");
        int y = 1;
            for (Skills rest : blackTeam) {
                System.out.println("Shark " + rest.id + ": life " + rest.life + ", power " + rest.power + ", strength " + rest.strength + " (index " + y + ")");
                blackShark = blackTeam.get(y - 1);
                DatabaseConnection.insertBlackShark();
                y++;
            }
        selectOpponent();if (opponent > blackTeam.size() - 1 || opponent < 0) {
            System.out.println("Wrong choice! Try again!");
            selectOpponent();
        }
        blackShark = blackTeam.get(opponent);
        opponentBlack = opponent;
        System.out.println("You have chosen: Black Shark " + blackShark.id + "\n");
    }

    private void random() {
        Random random = new Random();
        lifeRandom = random.nextInt(50) + 100;
        powerRandom = random.nextInt(15) + 10;
        strengthRandom = random.nextInt(5) + 1;
    }

    private void selectOpponent() {
        System.out.println("\nChoose (with INDEX) one SHARK from the list: ");
        opponent = Main.scanner.nextInt() - 1;
        Main.scanner.nextLine();
    }

    public void removeLoser() {
        if (whiteShark.life <= 0) {
            whiteTeam.remove(opponentWhite);
        }
        if (blackShark.life <= 0) {
            blackTeam.remove(opponentBlack);
        }
    }
}
