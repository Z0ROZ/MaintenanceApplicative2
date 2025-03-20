package calendar;

import event.Event;

import java.time.LocalDateTime;


public class CalendarManager {

    private final Calendar calendar;

    public CalendarManager() {
        this.calendar = new Calendar();
    }


    public void addEvent(Event event) {
        calendar.addEvent(event);
    }


    public void eventInPeriod(LocalDateTime debut, LocalDateTime fin) {
        calendar.eventInPeriod(debut, fin);
    }

    public void displayEvents() {
        calendar.displayEvents();
    }
}

