package JavaB;

import java.sql.SQLException;

public class LastHistories {

    private static int choice;

    public static void getLastHistories() throws SQLException {
        new LastHistories();
    }

    public static int getChoice() {
        return choice;
    }

    private LastHistories() throws SQLException {
        System.out.println("\nDo you want to see the last histories? Select number: 1 (yes), 0 (no)");
        int input = Main.scanner.nextInt();
        Main.scanner.nextLine();
        if (input == 0) {
            System.out.println("Exit");
        }
        if (input > 1 || input < 0) {
            System.out.println("Wrong choce!");
            new LastHistories();
        }

        if (input == 1) {
            System.out.println("There are " + DatabaseConnection.lastMatchID + " matches in the database.\n\nWhich one do you want to see?");
            choice = Main.scanner.nextInt();
            Main.scanner.nextLine();
                if (choice > 0 && choice <= DatabaseConnection.lastMatchID) {
                    DatabaseConnection.getHistory();
                }
        }
    }
}
