package action.menus;

import action.Action;
import action.ListAction;
import action.display_events.DisplayEventAction;
import action.display_events.DisplayEventDayAction;
import action.display_events.DisplayEventMonthAction;
import action.display_events.DisplayEventWeekAction;
import calendar.CalendarManager;

import java.util.Scanner;

public class DisplayEventMenuAction implements Action {
    private final Scanner scanner;
    private final ListAction listAction;

    public DisplayEventMenuAction(Scanner scanner, CalendarManager calendarManager) {
        this.scanner = scanner;
        this.listAction = new ListAction();

        listAction.addAction(new DisplayEventAction(calendarManager));
        listAction.addAction(new DisplayEventMonthAction(calendarManager,scanner));
        listAction.addAction(new DisplayEventWeekAction(calendarManager,scanner));
        listAction.addAction(new DisplayEventDayAction(calendarManager,scanner));
    }


    @Override
    public void execute() {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        listAction.displayActions();
        System.out.print("Votre choix : ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            listAction.execute(choice - 1);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }

    @Override
    public String getName() {
        return "Voir les événements";
    }
}
