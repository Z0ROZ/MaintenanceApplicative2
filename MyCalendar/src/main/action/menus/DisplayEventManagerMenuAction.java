package action.menus;

import action.Action;
import action.ListAction;
import action.display_events.DisplayEventAction;
import action.events_types.PeriodiqueAction;
import action.events_types.RendezVousAction;
import action.events_types.ReunionAction;
import calendar.CalendarManager;
import user.UserManager;

import java.util.Scanner;


public class DisplayEventManagerMenuAction implements Action {
    private final Scanner scanner;
    private final ListAction listAction;
    private final UserManager userManager;

    public DisplayEventManagerMenuAction(Scanner scanner, CalendarManager calendarManager, UserManager userManager) {
        this.scanner = scanner;
        this.userManager = userManager;
        this.listAction = new ListAction();

        this.listAction.addAction(new DisplayEventMenuAction(scanner,calendarManager));
        this.listAction.addAction(new RendezVousAction(calendarManager, scanner, userManager));
        this.listAction.addAction(new ReunionAction(calendarManager, scanner, userManager));
        this.listAction.addAction(new PeriodiqueAction(calendarManager, scanner, userManager));
        // Déconnexion
    }


    @Override
    public void execute() {
        while (userManager.isLoggedIn()) {
            System.out.println("\nBonjour, " + userManager.getCurrentUser().getUsername());
            System.out.println("=== Menu Gestionnaire d'Événements ===");
            listAction.displayActions();
            System.out.print("Votre choix : ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                listAction.execute(choice - 1);
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    @Override
    public String getName() {
        return "";
    }
}
