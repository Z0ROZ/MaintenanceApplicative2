package action.display_events;

import action.Action;
import calendar.CalendarManager;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DisplayEventMonthAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public DisplayEventMonthAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }


    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());

        LocalDateTime beginning = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime end = beginning.plusMonths(1).minusSeconds(1);

        calendarManager.eventInPeriod(beginning, end);
        calendarManager.displayEvents();
    }

    @Override
    public String getName() {
        return "Afficher les événements d'un MOIS précis";
    }
}
