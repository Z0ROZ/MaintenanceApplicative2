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
    private final UserOutput output;

    public CalendarLauncher() {
        this.scanner = new Scanner(System.in);
        this.calendarManager = new CalendarManager();
        this.output = new ConsoleUserOutput();
        this.userManager = new UserManager(scanner, output);
    }

    public void run() {
        while (true) {
            if (!userManager.isLoggedIn()) {
                DisplayAuthMenuAction menuAuth = new DisplayAuthMenuAction(scanner, userManager);
                menuAuth.execute();
            } else {
                try {
                    DisplayEventManagerMenuAction menuEvent = new DisplayEventManagerMenuAction(scanner, calendarManager, userManager);
                    menuEvent.execute();
                } catch (NumberFormatException e) {
                    output.displayError("Veuillez entrer un nombre valide.");
                }
            }
        }
    }
}