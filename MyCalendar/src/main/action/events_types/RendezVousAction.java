package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.types.RendezVous;
import event.primitives.DurationEvent;
import event.primitives.OwnerEvent;
import event.primitives.TitleEvent;
import user.UserManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RendezVousAction implements Action {
    private final CalendarManager calendarManager;
    private final UserManager userManager;
    private final Scanner scanner;

    public RendezVousAction(CalendarManager calendarManager, Scanner scanner, UserManager userManager) {
        this.calendarManager = calendarManager;
        this.userManager = userManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Titre du rendez-vous : ");
        String title = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure (0-23) : ");
        int hour = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Durée (minutes) : ");
        int duration = Integer.parseInt(scanner.nextLine());

        RendezVous rdv = new RendezVous(
                new TitleEvent(title),
                new OwnerEvent(userManager.getCurrentUser().getUsername()),
                LocalDateTime.of(year, month, day, hour, minute),
                new DurationEvent(duration)
        );

        calendarManager.addEvent(rdv);
        System.out.println("Rendez-vous ajouté !");
    }

    @Override
    public String getName() {
        return "Ajouter un rendez-vous personnel";
    }
}
