package action.display_events;

import action.Action;
import calendar.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DisplayEventDayAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public DisplayEventDayAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int day = Integer.parseInt(scanner.nextLine());

        LocalDateTime beginning = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime end = beginning.plusDays(1).minusSeconds(1);

        calendarManager.eventInPeriod(beginning, end);
        calendarManager.displayEvents();
    }

    @Override
    public String getName() {
        return "Afficher les événements d'un JOUR précis";
    }
}
