package JavaB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Figures {

    public static int numberShark;
    private static Skills whiteShark;
    private static Skills blackShark;

    private static int lifeRandom;
    private static int powerRandom;
    private static int strengthRandom;

    private int opponent;
    private int opponentWhite;
    private int opponentBlack;
    private static ArrayList<Skills> sharksList;
    private static ArrayList<Skills> whiteTeam;
    private static ArrayList<Skills> blackTeam;

    public static int setNumberShark(int numberShark) {
        Figures.numberShark = numberShark;
        return numberShark;
    }

    public static Skills getWhiteShark() {
        return whiteShark;
    }

    public static Skills getBlackShark() {
        return blackShark;
    }

    public static ArrayList<Skills> getWhiteTeam() {
        return whiteTeam;
    }

    public static ArrayList<Skills> getBlackTeam() {
        return blackTeam;
    }

    public static ArrayList<Skills> getTeamCreation() {
        return Figures.selectTeam();
    }

    private static ArrayList<Skills> selectTeam() {
        sharksList = new ArrayList<>(numberShark);
        for (int i = 0; i < numberShark; i++) {
            random();
            int idShark = i + 1;
            Skills shark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
            sharksList.add(i, shark);
        }
        return sharksList;
    }

    public void matchStart() throws SQLException {
        selectTeam();
        whiteTeam = sharksList;
        DatabaseConnection.insertWhiteSharks();
        white();
        selectTeam();
        blackTeam = sharksList;
        DatabaseConnection.insertBlackSharks();
        black();
    }

    public void white() {
        System.out.println("\nWHITE SHARKS TEAM:");
        int x = 1;
        for (Skills rest : whiteTeam) {
            System.out.println("Shark " + rest.id + ": life " + rest.life + ", power " + rest.power + ", strength " + rest.strength + " (index " + x + ")");
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

    public void black() {
        System.out.println("\nBLACK SHARKS TEAM:");
        int y = 1;
        for (Skills rest : blackTeam) {
            System.out.println("Shark " + rest.id + ": life " + rest.life + ", power " + rest.power + ", strength " + rest.strength + " (index " + y + ")");
            y++;
        }
        selectOpponent();
            if (opponent > blackTeam.size() - 1 || opponent < 0) {
            System.out.println("Wrong choice! Try again!");
            selectOpponent();
        }
        blackShark = blackTeam.get(opponent);
        opponentBlack = opponent;
        System.out.println("You have chosen: Black Shark " + blackShark.id + "\n");
    }

    private static void random() {
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
