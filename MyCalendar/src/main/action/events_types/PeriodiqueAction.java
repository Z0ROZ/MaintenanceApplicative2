package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.EventManager;
import event.types.Periodique;
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
        EventManager eventManager = new EventManager();

        System.out.println("=== Création d'un Événement Périodique ===");
        System.out.print("Titre de l'événement : ");
        String title= scanner.nextLine();

        LocalDateTime beginning = eventManager.setDate();

        System.out.print("Fréquence (en jours) : ");
        int frequency = Integer.parseInt(scanner.nextLine());
        FrequencyEvent frequencyDay = new FrequencyEvent(frequency);

        TitleEvent titleEvent = new TitleEvent(title);
        OwnerEvent ownerEvent = new OwnerEvent(userManager.getCurrentUser().getUsername().getValue());
        DurationEvent durationEvent = new DurationEvent(60);

        Event periodiqueEvent = new Periodique(titleEvent, ownerEvent, beginning, durationEvent, frequencyDay);

        calendarManager.addEvent(periodiqueEvent);

    }

    @Override
    public String getName() {
        return "Ajouter un évènement periodique";
    }
}
