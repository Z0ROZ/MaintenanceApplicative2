

import action.*;
import action.auth.LoginAction;
import action.auth.RegisterAction;
import action.menus.DisplayEventMenuAction;
import calendar.CalendarManager;

import user.UserManager;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendarManager = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager(scanner);

        ListAction menuConnexion = new ListAction();
        menuConnexion.addAction(new LoginAction(userManager));
        menuConnexion.addAction(new RegisterAction(userManager));


        while (true) {

                // Affichage du logo
                System.out.println("  _____         _                   _                __  __");
                System.out.println(" / ____|       | |                 | |              |  \\/  |");
                System.out.println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
                System.out.println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
                System.out.println("| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
                System.out.println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
                System.out.println("                                                                                   __/ |");
                System.out.println("                                                                                  |___/");
                System.out.println();

                System.out.println("\n=== Menu Principal ===");
                menuConnexion.displayActions();
                System.out.print("Votre choix : ");

            try {
                int choix = Integer.parseInt(scanner.nextLine());
                menuConnexion.execute(choix - 1);
                System.out.println(userManager);
                if (userManager.isLoggedIn()) {
                    DisplayEventMenuAction menuPrincipal = new DisplayEventMenuAction(scanner, calendarManager, userManager);
                    menuPrincipal.execute();
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }

        }
    }
}



