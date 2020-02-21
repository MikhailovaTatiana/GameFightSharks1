package JavaB;

import java.util.ArrayList;
import java.util.Random;

public class Figures {

    int numberShark;

    int idShark;
    int lifeRandom;
    int powerRandom;
    int strengthRandom;

    int opponent;
    ArrayList<Skills> whiteSharks;
    ArrayList<Skills> blackSharks;
    public Skills whiteShark;
    public Skills blackShark;

    public void selectWhiteSharks() {
        System.out.println("WHITE SHARKS TEAM:");
        whiteSharks = new ArrayList<Skills>(numberShark);
            for (int i = 0; i < numberShark; i++) {
                random();
                idShark = i + 1;
                whiteShark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
                whiteSharks.add(i, whiteShark);
                System.out.println("White Shark "+whiteShark.id+": life "+whiteShark.life+", power "+whiteShark.power+", strength "+whiteShark.strength);
            }
        selectOpponent();
        whiteShark = whiteSharks.get(opponent);
        System.out.println("You have chosen: White Shark " + whiteShark.id);
    }

    public void selectBlackSharks() {
        System.out.println("\nBLACK SHARK TEAM:");
        blackSharks = new ArrayList<Skills>(numberShark);
            for (int i = 0; i < numberShark; i++) {
                random();
                idShark = i + 1;
                blackShark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
                blackSharks.add(i, blackShark);
                System.out.println("Black Shark "+blackShark.id+": life "+blackShark.life+", power "+blackShark.power+", strength "+blackShark.strength);
            }
        selectOpponent();
        blackShark = blackSharks.get(opponent);
        System.out.println("You have chosen: Black Shark " + blackShark.id);
    }

    private void random() {
        Random random = new Random();
        lifeRandom = random.nextInt(50) + 100;
        powerRandom = random.nextInt(10) + 5;
        strengthRandom = random.nextInt(5) + 1;
    }

    int selectOpponent() {
        System.out.println("\nChoose (with number) one SHARK from the list: ");
        opponent  = Main.scanner.nextInt() - 1;
        Main.scanner.nextLine();
        return opponent;
    }
}
