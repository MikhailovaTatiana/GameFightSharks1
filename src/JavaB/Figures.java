package JavaB;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Figures {

    public int numberShark;

    public int idShark;
    public int lifeRandom;
    public int powerRandom;
    public int strengthRandom;

    public int opponent;

    Skills whiteShark;
    Skills blackShark;

    public void selectWhiteSharks() {
        System.out.println("WHITE SHARKS TEAM:");
        ArrayList<Skills> whiteSharks = new ArrayList<Skills>(numberShark);
            for (int i = 0; i < numberShark; i++) {
                random();
                idShark = i + 1;
                whiteShark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
                whiteSharks.add(i, whiteShark);
                System.out.println("White Shark "+whiteShark.id+": life "+whiteShark.life+", power "+whiteShark.power+", strength "+whiteShark.strength);
            }
    //    whiteSharks.remove(opponent);
    }

    public void selectBlackSharks() {
        System.out.println("\nBLACK SHARK TEAM:");
        ArrayList<Skills> blackSharks = new ArrayList<>(numberShark);
            for (int i = 0; i < numberShark; i++) {
                random();
                idShark = i + 1;
                blackShark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
                blackSharks.add(i, blackShark);
                System.out.println("Black Shark "+blackShark.id+": life "+blackShark.life+", power "+blackShark.power+", strength "+blackShark.strength);
            }
        //    blackSharks.remove(opponent);
    }

    private void random() {
        Random random = new Random();
        lifeRandom = random.nextInt(50) + 100;
        powerRandom = random.nextInt(10) + 5;
        strengthRandom = random.nextInt(5) + 1;
    }

    public Skills whiteShark() {
        selectOpponent();
        whiteShark = selectWhiteSharks().get(opponent);
        return whiteShark;
    }

    public Skills blackShark() {
        selectOpponent();
        blackShark = selectWhiteSharks().get(opponent);
        return blackShark;
    }

    private int selectOpponent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nChoose (with number) one SHARK from the list");
        opponent = sc.nextInt() - 1;
        sc.close();
        return opponent;
    }
}
