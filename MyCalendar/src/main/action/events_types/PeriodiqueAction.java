package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.Periodique;
import event.primitives.DureeEvenement;
import event.primitives.FrequenceJours;
import event.primitives.ProprietaireEvenement;
import event.primitives.TitreEvenement;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PeriodiqueAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public PeriodiqueAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    @Override
    public void executer() {
        System.out.println("=== Création d'un Événement Périodique ===");
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();

        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());

        System.out.print("Mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        System.out.print("Jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        System.out.print("Heure de début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());

        System.out.print("Minute de début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());

        LocalDateTime dateDebut = LocalDateTime.of(annee, mois, jour, heure, minute);

        System.out.print("Fréquence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());
        FrequenceJours frequenceJours = new FrequenceJours(frequence);

        TitreEvenement titreEvenement = new TitreEvenement(titre);
        ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement("Utilisateur");
        DureeEvenement dureeEvenement = new DureeEvenement(60);

        Event evenementPeriodique = new Periodique(titreEvenement, proprietaireEvenement, dateDebut, dureeEvenement, frequenceJours);

        calendarManager.ajouterEvenement(evenementPeriodique);

        System.out.println("Événement périodique créé avec succès !");
    }

    @Override
    public String getName() {
        return "Ajouter un évènement periodique";
    }
}
