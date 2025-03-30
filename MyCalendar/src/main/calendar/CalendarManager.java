package calendar;

import event.Event;
import event.primitives.EventId;
import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {
    private final Calendar calendar;
    private final CalendarOutput output;

    public CalendarManager() {
        this.calendar = new Calendar();
        this.output = new CalendarOutput();
    }

    public void addEvent(Event event) {
        calendar.validateAndAddEvent(event);
    }

    public List<Event> getEventsBetween(LocalDateTime start, LocalDateTime end) {
        return calendar.eventInPeriod(start, end);
    }

    public void displayEvents() {
        calendar.displayEvents();
    }

    public void removeEvent(EventId id) {
        calendar.removeEventAndNotify(id);
    }
}

