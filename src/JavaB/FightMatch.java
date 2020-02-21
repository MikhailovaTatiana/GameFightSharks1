package JavaB;

public class FightMatch {

    Skills whiteShark;
    Skills blackShark;
    int upgrade;

    public FightMatch(Skills whiteShark, Skills blackShark, int upgrade) {
        this.whiteShark = whiteShark;
        this.blackShark = blackShark;
        this.upgrade = upgrade;
    }

    public void fight() {
        System.out.println("White Shark " + whiteShark.id + " has life " + whiteShark.life);
        System.out.println("Black Shark " + blackShark.id + " has life " + (blackShark.life - upgrade) + " now");
        while (whiteShark.life > 0 && blackShark.life > 0) {
            System.out.println("\nStrike!");
            whiteShark.life = whiteShark.life + whiteShark.strength - blackShark.power;
            System.out.println("White Shark " + whiteShark.id + " has life " + whiteShark.life);
            blackShark.life = blackShark.life + blackShark.strength - whiteShark.power;
            System.out.print("Black Shark " + blackShark.id + " has life " + blackShark.life);
            Main.scanner.nextLine();
        }
    }
}