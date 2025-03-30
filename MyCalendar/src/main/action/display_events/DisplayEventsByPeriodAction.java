package action.display_events;

import action.Action;
import calendar.CalendarManager;
import event.Event;
import event.EventManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class DisplayEventsByPeriodAction implements Action {
    private final CalendarManager calendarManager;

    public DisplayEventsByPeriodAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
    }

    @Override
    public void execute() {
        EventManager eventManager = new EventManager();

        System.out.println("=== Affichage des événements sur une période ===");
        System.out.println("Date de début :");
        LocalDateTime start = eventManager.setDate();

        System.out.println("Date de fin :");
        LocalDateTime end = eventManager.setDate();

        if (end.isBefore(start)) {
            System.out.println("Erreur : La date de fin doit être après la date de début");
            return;
        }

        List<Event> events = calendarManager.getEventsBetween(start, end);

        if (events.isEmpty()) {
            System.out.println("Aucun événement trouvé sur cette période");
            return;
        }

        System.out.println("Événements trouvés :");
        events.forEach(event -> System.out.println("- " + event.description()));
    }

    @Override
    public String getName() {
        return "Afficher les événements sur une période";
    }
}