package JavaB;

public class TeamNumbers {

    private int numbers;

    public int getNumbers() {
        return numbers;
    }

    public void selectNambers() {

        System.out.println("\nSelect numbers of members in each team: 3, 4, 5 or 0 (close)");
            numbers = Main.scanner.nextInt();
            Main.scanner.nextLine();
            if (numbers == 0) {
                System.out.println("EXIT");
            } else if (numbers >= 3 && numbers <= 5) {
                System.out.println("The game starts...");
            } else {
                System.out.println("Wrong choice! Try again!");
                selectNambers();
            }
    }
}