package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.RendezVous;
import event.primitives.DureeEvenement;
import event.primitives.ProprietaireEvenement;
import event.primitives.TitreEvenement;
import user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RendezVousAction implements Action {
    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final Scanner scanner;

    public RendezVousAction(CalendarManager calendarManager, Scanner scanner, UserManager userManager) {
        this.calendarManager = calendarManager;
        this.userManager = userManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Titre du rendez-vous : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        RendezVous rdv = new RendezVous(
                new TitreEvenement(titre),
                new ProprietaireEvenement(userManager.getCurrentUser().getUsername()),
                LocalDateTime.of(annee, mois, jour, heure, minute),
                new DureeEvenement(duree)
        );

        calendarManager.addEvent(rdv);
        System.out.println("Rendez-vous ajouté !");
    }

    @Override
    public String getName() {
        return "Ajouter un rendez-vous personnel";
    }
}
