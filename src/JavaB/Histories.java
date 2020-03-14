package JavaB;

import java.sql.SQLException;

public class Histories {

    private static int choice;

    public static void getLastHistories() throws SQLException {
        new Histories();
    }

    public static int getChoice() {
        return choice;
    }

    private Histories() throws SQLException {
        System.out.println("\nDo you want to see some history? Select number: 1 (yes), 0 (no)");
        int input = Main.scanner.nextInt();
        Main.scanner.nextLine();
        if (input == 0) {
            System.out.println("Exit");
        }
        if (input > 1 || input < 0) {
            System.out.println("Wrong choce! White again!");
            new Histories();
        }

        if (input == 1) {
            System.out.println("There are " + DatabaseConnection.lastMatchID + " matches in the database.\n\nWhich one do you want to see?");
            choice = Main.scanner.nextInt();
            Main.scanner.nextLine();
                if (choice > 0 && choice <= DatabaseConnection.lastMatchID) {
                    DatabaseConnection.getHistory();
                }
            new Histories();
        }
    }
}
