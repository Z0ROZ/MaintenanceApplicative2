package action.display_events;

import action.Action;
import calendar.CalendarManager;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DisplayEventWeekAction implements Action {

    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public DisplayEventWeekAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Entrez l'année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int week = Integer.parseInt(scanner.nextLine());

        LocalDateTime beginning = LocalDateTime.of(year, week, 1, 0, 0);
        LocalDateTime end = beginning.plusDays(7).minusSeconds(1);

        calendarManager.eventInPeriod(beginning, end);
        calendarManager.displayEvents();

    }

    public String getName() {
        return "Afficher les événements d'une SEMAINE précise";
    }

}
