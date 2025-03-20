

import action.*;
import action.auth.ConnectAction;
import action.auth.RegisterAction;
import action.display_events.DisplayEventAction;
import action.events_types.PeriodiqueAction;
import action.events_types.RendezVousAction;
import action.events_types.ReunionAction;
import calendar.CalendarManager;

import user.UserManager;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();
        Scanner scanner = new Scanner(System.in);
        UserManager utilisateurManager = new UserManager(scanner);

        ListAction listeAction = new ListAction();
        listeAction.addAction(new ConnectAction(utilisateurManager));
        listeAction.addAction(new RegisterAction(utilisateurManager));
        listeAction.addAction(new DisplayEventAction(calendar));
        listeAction.addAction(new RendezVousAction(calendar, scanner));
        listeAction.addAction(new ReunionAction(calendar, scanner));
        listeAction.addAction(new PeriodiqueAction(calendar, scanner));

        while (true) {
            try {
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

                // Affichage de la liste des actions
                listeAction.displayActions();
                System.out.print("Votre choix : ");
                int choix = Integer.parseInt(scanner.nextLine());  // Prend l'input de l'utilisateur
                listeAction.execute(choix - 1);  // Exécute l'action correspondante
            } catch (NumberFormatException e) {
                // Si l'utilisateur entre un nombre invalide
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }
}



