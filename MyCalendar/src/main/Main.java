

import action.menus.DisplayAuthMenuAction;
import action.menus.DisplayEventManagerMenuAction;
import calendar.CalendarManager;

import user.UserManager;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendarManager = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager(scanner);



        while (true) {
            DisplayAuthMenuAction menuPrincipal = new DisplayAuthMenuAction(scanner,userManager);
            menuPrincipal.execute();
            try {
                if (userManager.isLoggedIn()) {
                    DisplayEventManagerMenuAction menuEvent = new DisplayEventManagerMenuAction(scanner, calendarManager, userManager);
                    menuEvent.execute();
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }

        }
    }
}



