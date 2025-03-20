package action.display_events;

import calendar.CalendarManager;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class DisplayEventWeekAction {

    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public DisplayEventWeekAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    public void executer() {
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        LocalDateTime debut = LocalDateTime.of(annee,semaine, 1, 0, 0);
        LocalDateTime fin= debut.plusDays(7).minusSeconds(1);

        calendarManager.evenementsDansPeriode(debut, fin);
        calendarManager.afficherEvenements();

    }

    public String getName() {
        return "Afficher les événements d'une SEMAINE précise";
    }

}
