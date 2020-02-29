package JavaB;

public class LastHistories {

    public static void getLastHistories() {
        new LastHistories();
    }

    private LastHistories() {
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
    }
}
