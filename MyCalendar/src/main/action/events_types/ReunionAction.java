package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.types.Reunion;
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
        LocalDateTime beginning = LocalDateTime.of(year, month, day, hour, minute);

        System.out.print("Durée de la réunion (en minutes) : ");
        int duration = Integer.parseInt(scanner.nextLine());

        System.out.print("Lieu de la réunion : ");
        String place = scanner.nextLine();

        System.out.println("Ajouter des participants (tapez 'non' pour arrêter) : ");
        List<String> participants = new ArrayList<>();
        participants.add("Organisateur");
        String participant = scanner.nextLine();
        while (!participant.equalsIgnoreCase("non")) {
            participants.add(participant);
            System.out.print("Participant : ");
            participant = scanner.nextLine();
        }


        TitleEvent titleEvent = new TitleEvent(title);
        OwnerEvent ownerEvent = new OwnerEvent(userManager.getCurrentUser().getUsername());
        DurationEvent durationEvent = new DurationEvent(duration);
        PlaceEvent placeEvent = new PlaceEvent(place);
        ParticipantsEvent participantsEvent = new ParticipantsEvent(participants);

        Event reunion = new Reunion(titleEvent, ownerEvent, beginning, durationEvent, placeEvent, participantsEvent);

        calendarManager.addEvent(reunion);

        System.out.println("Réunion créée avec succès !");
    }


    @Override
    public String getName() {
        return "Ajouter une réunion";
    }
}
