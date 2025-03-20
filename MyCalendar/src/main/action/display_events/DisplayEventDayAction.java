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
    public void executer() {
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = LocalDateTime.of(annee, mois, jour, 0, 0);
        LocalDateTime fin = debut.plusDays(1).minusSeconds(1);

        calendarManager.evenementsDansPeriode(debut, fin);
        calendarManager.afficherEvenements();
    }

    @Override
    public String getName() {
        return "";
    }
}
