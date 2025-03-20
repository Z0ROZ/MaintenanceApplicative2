package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.Reunion;
import event.primitives.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReunionAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public ReunionAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    @Override
    public void executer() {
        System.out.println("=== Création d'une Réunion ===");
        System.out.print("Titre de la réunion : ");
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

        System.out.print("Durée de la réunion (en minutes) : ");
        int duree = Integer.parseInt(scanner.nextLine());

        System.out.print("Lieu de la réunion : ");
        String lieu = scanner.nextLine();

        System.out.println("Ajouter des participants (tapez 'non' pour arrêter) : ");
        List<String> participants = new ArrayList<>();
        participants.add("Organisateur");
        String participant = scanner.nextLine();
        while (!participant.equalsIgnoreCase("non")) {
            participants.add(participant);
            System.out.print("Participant : ");
            participant = scanner.nextLine();
        }


        TitreEvenement titreEvenement = new TitreEvenement(titre);
        ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement("Utilisateur");
        DureeEvenement dureeEvenement = new DureeEvenement(duree);
        LieuEvenement lieuEvenement = new LieuEvenement(lieu);
        ParticipantsEvenement participantsEvenement = new ParticipantsEvenement(participants);

        Event reunion = new Reunion(titreEvenement, proprietaireEvenement, dateDebut, dureeEvenement, lieuEvenement, participantsEvenement);

        calendarManager.ajouterEvenement(reunion);

        System.out.println("Réunion créée avec succès !");
    }


    @Override
    public String getName() {
        return "Ajouter une réunion";
    }
}
