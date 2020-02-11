package JavaB;

import java.io.IOException;
import java.util.Scanner;

public class MemberNumbers {

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select numbers of members in each team: 3, 4, 5 or 0 (close)");
        try {
            int numbers = sc.nextInt();
            if (numbers==0) {
                System.out.println("EXIT");
            } else if (numbers>0 && numbers<=5) {
                System.out.println("The game starts...");
                FightMatch teamNumbers = new FightMatch();
                for (int i=1; i<=numbers; i++)
                    teamNumbers.winner();
            } else {
                System.out.println("Wrong choice! Try again!");
                start();
            }

            /*switch (numbers) {
                case 0:
                    System.out.println("EXIT");
                    break;
                case 3:
                    System.out.println("The game starts...");
                    FightMatch teamThree = new FightMatch();
                    teamThree.winner();
                    break;
                case 4:
                    System.out.println("The game starts...");
                    FightMatch teamFour = new FightMatch();
                    teamFour.winner();
                    break;
                case 5:
                    System.out.println("The game starts...");
                    FightMatch teamFive = new FightMatch();
                    teamFive.winner();
                    break;
                default:
                    System.out.println("Wrong choice! Try again!");
                    start();
            }*/
        } catch (Exception e) {
            System.out.println(e);
            start();
        }
        sc.close();
    }
}