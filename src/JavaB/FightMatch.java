package JavaB;

import java.io.IOException;
import java.util.Random;

public class FightMatch {

    private static int fightMatch (int a, int b) {

        while (a > 0 && b > 0) {
            Random rnd = new Random();
            int x = rnd.nextInt(10) + 1;
            a -= x;
            System.out.println("You have: " + a);
            int y = rnd.nextInt(10) + 1;
            b -= y;
            System.out.println("Your opponent has: " + b);
        }
        if (a > 0) {
            return a;
        } else
            return b;
    }

    public void winner() throws IOException {
        Weapon w = new Weapon();
        w.weaponSelect();
        int life = fightMatch (50 + w.upgrade, 50);
        if (life > 0) {
            System.out.println("You have totally " + life);
        }
        else {
            System.out.println("You have gone...");
        }
    }
}
