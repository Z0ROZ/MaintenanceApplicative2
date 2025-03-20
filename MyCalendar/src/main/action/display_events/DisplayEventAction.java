package action.display_events;


import action.Action;
import calendar.CalendarManager;

public class DisplayEventAction implements Action {
    private CalendarManager calendarManager;

    public DisplayEventAction(CalendarManager calendarManager) {
        this.calendarManager = calendarManager;
    }

    @Override
    public void executer() {
        calendarManager.afficherEvenements();
    }

    @Override
    public String getName() {
        return "Afficher TOUS les événements";
    }
}
