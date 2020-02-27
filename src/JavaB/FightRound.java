package JavaB;

public class FightRound {

    private Skills whiteShark;
    private Skills blackShark;
    private int upgrade1;
    private int upgrade2;

    public FightRound(Skills whiteShark, Skills blackShark, int upgrade1, int upgrade2) {
        this.whiteShark = whiteShark;
        this.blackShark = blackShark;
        this.upgrade1 = upgrade1;
        this.upgrade2 = upgrade2;
    }

    public void fight() {
        whiteShark.life = whiteShark.life - upgrade2;
        blackShark.life = blackShark.life - upgrade1;
        System.out.println("White Shark " + whiteShark.id + " has life " + whiteShark.life + " now");
        System.out.println("Black Shark " + blackShark.id + " has life " + blackShark.life + " now");
            for (int i = 0; i < 7; i++) {
                if (whiteShark.life <= 0 || blackShark.life <= 0) {
                    break;
                }
                System.out.println("\nStrike!");
                whiteShark.life = whiteShark.life + whiteShark.strength - blackShark.power;
                System.out.println("White Shark " + whiteShark.id + " has life " + whiteShark.life);
                blackShark.life = blackShark.life + blackShark.strength - whiteShark.power;
                System.out.print("Black Shark " + blackShark.id + " has life " + blackShark.life);
                Main.scanner.nextLine();
            }
    }
}