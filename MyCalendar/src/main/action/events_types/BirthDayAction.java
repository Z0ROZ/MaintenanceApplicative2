package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.EventManager;
import event.types.Birthday;
import event.primitives.DurationEvent;
import event.primitives.OwnerEvent;
import event.primitives.TitleEvent;
import user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BirthDayAction implements Action {
    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final Scanner scanner;

    public BirthDayAction(CalendarManager calendarManager, Scanner scanner, UserManager userManager) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        EventManager eventManager = new EventManager();

        System.out.println("=== Création d'un Anniversaire ===");
        System.out.print("Nom de la personne : ");
        String personName = scanner.nextLine();

        LocalDateTime beginning = eventManager.setDate();

        TitleEvent titleEvent = new TitleEvent("Anniversaire de " + personName);
        OwnerEvent ownerEvent = new OwnerEvent(userManager.getCurrentUser().getUsername().getValue());
        DurationEvent durationEvent = new DurationEvent(1440); // durée de 24h

        Event birthdayEvent = new Birthday(titleEvent, ownerEvent, beginning, durationEvent);
        calendarManager.addEvent(birthdayEvent);

        System.out.println("Anniversaire créé avec succès !");
    }

    @Override
    public String getName() {
        return "Ajouter un anniversaire";
    }
}