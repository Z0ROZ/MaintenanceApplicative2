package action.events_types;

import action.Action;
import calendar.CalendarManager;
import event.EventManager;
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
        EventManager eventManager = new EventManager();

        System.out.print("Titre du rendez-vous : ");
        String title = scanner.nextLine();

        LocalDateTime beginning = eventManager.setDate();
        System.out.print("Durée (minutes) : ");

        int duration = Integer.parseInt(scanner.nextLine());

        RendezVous rdv = new RendezVous(
                new TitleEvent(title),
                new OwnerEvent(userManager.getCurrentUser().getUsername()),
                beginning,
                new DurationEvent(duration)
        );

        calendarManager.addEvent(rdv);
    }

    @Override
    public String getName() {
        return "Ajouter un rendez-vous personnel";
    }
}
