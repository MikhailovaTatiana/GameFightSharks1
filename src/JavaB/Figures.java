package JavaB;

import java.util.ArrayList;
import java.util.Random;

public class Figures {

    private int numberShark;
    private Skills whiteShark;
    private Skills blackShark;

    private int lifeRandom;
    private int powerRandom;
    private int strengthRandom;

    private int opponent;
    private ArrayList<Skills> sharksList;
    private ArrayList<Skills> whiteTeam;
    private ArrayList<Skills> blackTeam;

    public void setNumberShark(int numberShark) {
        this.numberShark = numberShark;
    }

    public Skills getWhiteShark() {
        return whiteShark;
    }

    public Skills getBlackShark() {
        return blackShark;
    }

    public ArrayList<Skills> getWhiteTeam() {
        return whiteTeam;
    }

    public ArrayList<Skills> getBlackTeam() {
        return blackTeam;
    }

    private void selectTeam() {
        sharksList = new ArrayList<>(numberShark);
        for (int i = 0; i < numberShark; i++) {
            random();
            int idShark = i + 1;
            Skills shark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
            sharksList.add(i, shark);
        }
    }

    public void match() {
        selectTeam();
        whiteTeam = sharksList;
        white();
        selectTeam();
        blackTeam = sharksList;
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
        whiteShark = whiteTeam.get(opponent);
        System.out.println("You have chosen: White Shark " + whiteShark.id);
        // whiteTeam.remove(opponent);
    }

    public void black() {
        System.out.println("\nBLACK SHARKS TEAM:");
        int y = 1;
        for (Skills rest : blackTeam) {
            System.out.println("Shark " + rest.id + ": life " + rest.life + ", power " + rest.power + ", strength " + rest.strength + " (index " + y + ")");
            y++;
        }
        selectOpponent();
        blackShark = blackTeam.get(opponent);
        System.out.println("You have chosen: Black Shark " + blackShark.id + "\n");
        // blackTeam.remove(opponent);
    }

    private void random() {
        Random random = new Random();
        lifeRandom = random.nextInt(50) + 100;
        powerRandom = random.nextInt(15) + 5;
        strengthRandom = random.nextInt(5) + 1;
    }

    private void selectOpponent() {
        System.out.println("\nChoose (with ROW number) one SHARK from the list: ");
        opponent = Main.scanner.nextInt() - 1;
        Main.scanner.nextLine();
    }

    public void sharkLosers() {

        if(whiteShark.life <= 0) {
            whiteTeam.remove(opponent);
        }
        if(blackShark.life <= 0) {
            blackTeam.remove(opponent);
        }
    }
}
