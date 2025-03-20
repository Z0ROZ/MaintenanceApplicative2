package action.display_events;

import action.Action;
import calendar.CalendarManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DisplayEventMonthAction implements Action {
    private CalendarManager calendarManager;
    private Scanner scanner;

    public DisplayEventMonthAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }


    @Override
    public void executer() {
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutJour = LocalDateTime.of(annee, mois, 1, 0, 0);
        calendarManager.evenementsDansPeriode(debutJour, debutJour.plusMonths(1).minusSeconds(1));
        calendarManager.afficherEvenements();
    }

    @Override
    public String getName() {
        return "Afficher les événements d'un MOIS précis";
    }
}
