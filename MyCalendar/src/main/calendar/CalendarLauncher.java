package calendar;

import action.menus.DisplayAuthMenuAction;
import action.menus.DisplayEventManagerMenuAction;
import user.UserManager;
import user.message.ConsoleUserOutput;
import user.message.UserOutput;

import java.util.Scanner;

public class CalendarLauncher {

    private final Scanner scanner;
    private final CalendarManager calendarManager;
    private final UserManager userManager;

    public CalendarLauncher() {
        this.scanner = new Scanner(System.in);
        this.calendarManager = new CalendarManager();
        UserOutput output = new ConsoleUserOutput();
        this.userManager = new UserManager(scanner, output);
    }

    public void run() {
        while (true) {
            DisplayAuthMenuAction menuPrincipal = new DisplayAuthMenuAction(scanner, userManager);
            menuPrincipal.execute();
            try {
                if (userManager.isLoggedIn()) {
                    DisplayEventManagerMenuAction menuEvent = new DisplayEventManagerMenuAction(scanner, calendarManager, userManager);
                    menuEvent.execute();
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }

        }
    }
}

