package JavaB;

import java.util.Scanner;

public class TeamNumbers {
    public int numbers;

    public int start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSelect numbers of members in each team: 3, 4, 5 or 0 (close)");
        try {
            numbers = sc.nextInt();
            if (numbers == 0) {
                System.out.println("EXIT");
            } else if (numbers >= 3 && numbers <= 5) {
                System.out.println("The game starts...\n");
            } else {
                System.out.println("Wrong choice! Try again!");
                start();
            }
        } catch (Exception e) {
            System.out.println(e);
            start();
        }
        sc.close();
        return numbers;
    }

}