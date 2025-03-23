package calendar;

import event.Event;

import java.time.LocalDateTime;


import java.util.List;

public class CalendarManager {

    private final Calendar calendar;

    public CalendarManager() {
        this.calendar = new Calendar();
    }

    public void addEvent(Event event) {
        if (isTitleUnique(event)) {
            calendar.addEvent(event);
            System.out.println("Événement ajouté avec succès !");
        } else {
            System.out.println("Erreur : Un événement avec ce titre existe déjà.");
        }
    }

    private boolean isTitleUnique(Event event) {
        return calendar.getEvents().stream()
                .noneMatch(existingEvent -> existingEvent.getTitle().valeur().equals(event.getTitle().valeur()));
    }

    public List<Event> eventInPeriod(LocalDateTime beginning, LocalDateTime end) {
        List<Event> eventsInPeriod = calendar.eventInPeriod(beginning, end);

        eventsInPeriod.forEach(e -> System.out.println(e.description()));

        return eventsInPeriod;
    }

    public void displayEvents() {
        calendar.displayEvents();
    }
}


