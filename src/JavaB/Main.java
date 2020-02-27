package JavaB;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        new DatabaseConnection().getInstance();

        new Match();

        scanner.close();
    }
}
