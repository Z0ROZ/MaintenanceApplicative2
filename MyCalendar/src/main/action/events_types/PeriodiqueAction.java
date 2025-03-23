package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.Periodique;
import event.primitives.DurationEvent;
import event.primitives.FrequencyEvent;
import event.primitives.OwnerEvent;
import event.primitives.TitleEvent;
import user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PeriodiqueAction implements Action {
    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final Scanner scanner;

    public PeriodiqueAction(CalendarManager calendarManager, Scanner scanner, UserManager userManager) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        System.out.println("=== Création d'un Événement Périodique ===");
        System.out.print("Titre de l'événement : ");
        String title= scanner.nextLine();

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

        System.out.print("Fréquence (en jours) : ");
        int frequency = Integer.parseInt(scanner.nextLine());
        FrequencyEvent frequencyDay = new FrequencyEvent(frequency);

        TitleEvent titleEvent = new TitleEvent(title);
        OwnerEvent ownerEvent = new OwnerEvent(userManager.getCurrentUser().getUsername());
        DurationEvent durationEvent = new DurationEvent(60);

        Event periodiqueEvent = new Periodique(titleEvent, ownerEvent, beginning, durationEvent, frequencyDay);

        calendarManager.addEvent(periodiqueEvent);

        System.out.println("Événement périodique créé avec succès !");
    }

    @Override
    public String getName() {
        return "Ajouter un évènement periodique";
    }
}
