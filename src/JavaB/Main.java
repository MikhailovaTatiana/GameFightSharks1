package JavaB;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        DatabaseConnection.getInstance();
        new Match();
        Histories.getLastHistories();

        scanner.close();
        DatabaseConnection.getClose();
    }
}
