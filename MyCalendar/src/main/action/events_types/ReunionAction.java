package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.Reunion;
import event.primitives.*;
import user.UserManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReunionAction implements Action {
    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final Scanner scanner;

    public ReunionAction(CalendarManager calendarManager, Scanner scanner, UserManager userManager) {
        this.calendarManager = calendarManager;
        this.userManager = userManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("=== Création d'une Réunion ===");
        System.out.print("Titre de la réunion : ");
        String title = scanner.nextLine();
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
        LocalDateTime dateDebut = LocalDateTime.of(year, month, day, hour, minute);

        System.out.print("Durée de la réunion (en minutes) : ");
        int duration = Integer.parseInt(scanner.nextLine());

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


        TitreEvenement titreEvenement = new TitreEvenement(title);
        ProprietaireEvenement proprietaireEvenement = new ProprietaireEvenement(userManager.getCurrentUser().getUsername());
        DureeEvenement dureeEvenement = new DureeEvenement(duration);
        LieuEvenement lieuEvenement = new LieuEvenement(lieu);
        ParticipantsEvenement participantsEvenement = new ParticipantsEvenement(participants);

        Event reunion = new Reunion(titreEvenement, proprietaireEvenement, dateDebut, dureeEvenement, lieuEvenement, participantsEvenement);

        calendarManager.addEvent(reunion);

        System.out.println("Réunion créée avec succès !");
    }


    @Override
    public String getName() {
        return "Ajouter une réunion";
    }
}
