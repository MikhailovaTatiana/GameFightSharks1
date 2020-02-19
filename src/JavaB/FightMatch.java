package JavaB;

public class FightMatch {

    Skills whiteShark;
    Skills blackShark;
    private int times;

    int upgrade;

    public FightMatch(Skills whiteShark, Skills blackShark) {
        this.whiteShark = whiteShark;
        this.blackShark = blackShark;
    }

    public void fight() {
        System.out.println("Whiteshark has life " + whiteShark.life);
        times = 5;
        System.out.println("White Shark: " + whiteShark.id + " has life " + whiteShark.life);
        System.out.println("Black Shark: " + blackShark.id + " has life " + blackShark.life);
        for (int i = 0; i < times; i++) {
            whiteShark.life = whiteShark.life + whiteShark.strength + upgrade - blackShark.power;
            System.out.println("White Shark: " + whiteShark.id + " has life " + whiteShark.life);
            blackShark.life = blackShark.life + blackShark.strength - whiteShark.power;
            System.out.println("Black Shark: " + blackShark.id + " has life " + blackShark.life);
        }
    }
}