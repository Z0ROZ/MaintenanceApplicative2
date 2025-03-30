package action.display_events;

import action.Action;
import calendar.CalendarManager;
import event.primitives.EventId;
import java.util.Scanner;

public class RemoveEventAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public RemoveEventAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("=== Suppression d'un événement ===");
        System.out.print("Identifiant de l'événement : ");
        String id = scanner.nextLine();

        calendarManager.removeEvent(new EventId(id));
    }

    @Override
    public String getName() {
        return "Supprimer un événement";
    }
}