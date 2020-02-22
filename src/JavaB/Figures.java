package JavaB;

import java.util.ArrayList;
import java.util.Random;

public class Figures {

    private int numberShark;

    private int idShark;
    private int lifeRandom;
    private int powerRandom;
    private int strengthRandom;

    private int opponent;
    private ArrayList<Skills> sharksList;
    ArrayList<Skills> whiteTeam;
    ArrayList<Skills> blackTeam;
    private Skills shark;
    public Skills whiteShark;
    public Skills blackShark;
    private int x = 0;
    private int y = 0;

    public void setNumberShark(int numberShark) {
        this.numberShark = numberShark;
    }

    public void selectTeam() {
        sharksList = new ArrayList<>(numberShark);
            for (int i = 0; i < numberShark; i++) {
                random();
                idShark = i + 1;
                shark = new Skills(idShark, lifeRandom, powerRandom, strengthRandom);
                sharksList.add(i, shark);
            }
    }

    void match() {
        selectTeam();
        whiteTeam = sharksList;
        white();
        selectTeam();
        blackTeam = sharksList;
        black();
    }

    public void white() {
        System.out.println("\nWHITE SHARKS TEAM:");
            for (Skills rest : whiteTeam) {
                System.out.println("Shark "+ rest.id+": life "+ rest.life+", power "+ rest.power+", strength "+ rest.strength);
            }
        selectOpponent();
        whiteShark = whiteTeam.get(opponent);
        System.out.println("You have chosen: White Shark " + whiteShark.id);
        whiteTeam.remove(opponent);
    }

    public void black () {
        System.out.println("\nBLACK SHARKS TEAM:");
            for (Skills rest : blackTeam) {
                System.out.println("Shark "+ rest.id+": life "+ rest.life+", power "+ rest.power+", strength "+ rest.strength);
            }
        selectOpponent();
        blackShark = blackTeam.get(opponent);
        System.out.println("You have chosen: Black Shark " + blackShark.id + "\n");
        blackTeam.remove(opponent);
    }

/*    public void selectWhiteShark() {
        System.out.println("WHITE SHARKS TEAM:");
        selectTeam();
        whiteTeam = sharksList;
        selectOpponent();
        whiteShark = whiteTeam.get(opponent);
        System.out.println("You have chosen: White Shark " + whiteShark.id);
        whiteTeam.remove(opponent);
    }

    public void selectBlackShark() {
        System.out.println("\nBLACK SHARKS TEAM:");
        selectTeam();
        blackTeam = sharksList;
        selectOpponent();
        blackShark = blackTeam.get(opponent);
        System.out.println("You have chosen: Black Shark " + blackShark.id);
        blackTeam.remove(opponent);
    }   */

    private void random() {
        Random random = new Random();
        lifeRandom = random.nextInt(50) + 100;
        powerRandom = random.nextInt(10) + 5;
        strengthRandom = random.nextInt(5) + 1;
    }

    private int selectOpponent() {
        System.out.println("\nChoose (with number) one SHARK from the list: ");
        opponent  = Main.scanner.nextInt() - 1;
        Main.scanner.nextLine();
        return opponent;
    }
}
