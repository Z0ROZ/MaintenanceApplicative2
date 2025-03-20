package action.display_events;

import action.Action;
import calendar.CalendarManager;

public class DisplayEventAction implements Action {
    private final CalendarManager calendarManager;

    public DisplayEventAction(CalendarManager calendarManager) {
        this.calendarManager = calendarManager;
    }

    @Override
    public void execute() {
        calendarManager.displayEvents();
    }

    @Override
    public String getName() {
        return "Afficher TOUS les événements";
    }
}
