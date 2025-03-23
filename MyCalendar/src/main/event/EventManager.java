package event;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EventManager {
    private static final Scanner scanner = new Scanner(System.in);


    public LocalDateTime setDate() {

        System.out.print("Année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.print("Mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());

        System.out.print("Jour (1-31) : ");
        int day = Integer.parseInt(scanner.nextLine());

        System.out.print("Heure de début (0-23) : ");
        int hour = Integer.parseInt(scanner.nextLine());

        System.out.print("Minute de début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());

        return LocalDateTime.of(year, month, day, hour, minute);
    }
}
