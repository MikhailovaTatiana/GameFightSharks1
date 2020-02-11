package JavaB;

import java.io.IOException;
import java.util.Scanner;

public class Weapon {

    public int upgrade;
    public int weaponSelect() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose with number: 0 nothing (-), 1 arbalest (+10), 2 chopper (+15), 3 grenade (+20)");
        try {
            int weapon = sc.nextInt();
            switch (weapon) {
                case 0:
                    upgrade = 0;
                    return upgrade;
                case 1:
                    System.out.println("You have got +10 to your life");
                    upgrade = 10;
                    return upgrade;
                case 2:
                    System.out.println("You have got +15 to your life");
                    upgrade = 15;
                    return upgrade;
                case 3:
                    System.out.println("You have got +20 to your life");
                    upgrade = 20;
                    return upgrade;
                default:
                    System.out.println("Wrong choice! Try again!");
                    weaponSelect();
            }
        } catch (Exception e) {
            System.out.println(e);
            weaponSelect();
        }
        sc.close();
        return upgrade;
    }
}
