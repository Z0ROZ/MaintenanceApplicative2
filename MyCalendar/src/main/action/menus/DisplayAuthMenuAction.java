package action.menus;

import action.Action;
import action.ListAction;
import action.auth.LoginAction;
import action.auth.RegisterAction;
import user.UserManager;

import java.util.Scanner;

public class DisplayAuthMenuAction implements Action {
    private final Scanner scanner;
    private final ListAction listAction;

    public DisplayAuthMenuAction(Scanner scanner, UserManager userManager) {
        this.scanner = scanner;
        this.listAction = new ListAction();

        this.listAction.addAction(new LoginAction(userManager));
        this.listAction.addAction(new RegisterAction(userManager));

    }

    @Override
    public void execute() {
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
        return "Menu Principal";
    }
}
