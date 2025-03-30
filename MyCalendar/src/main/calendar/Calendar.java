package calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import event.Event;
import event.primitives.EventId;

public class Calendar {

    private final List<Event> events;

    public Calendar() {
        this.events = new ArrayList<>();
    }


    public List<Event> findConflicts(Event newEvent) {
        return events.stream()
                .filter(existingEvent -> existingEvent.overlaps(newEvent))
                .collect(Collectors.toList());
    }

    public void addEvent(Event event) {
        List<Event> conflicts = findConflicts(event);
        if (!conflicts.isEmpty()) {
            System.out.println("Impossible d'ajouter l'événement - Conflits détectés :");
            conflicts.forEach(e -> System.out.println("- " + e.description()));

        }
        events.add(event);
        System.out.println("Événement ajouté avec succès");
    }



    public List<Event> eventInPeriod(LocalDateTime beginning, LocalDateTime end) {
        return events.stream()
                .filter(event -> event.isInPeriod(beginning, end))
                .collect(Collectors.toList());
    }

    public void displayEvents() {
        events.forEach(e -> System.out.println(e.description()));
    }

    public List<Event> getEvents() {
        return events;
    }

    public boolean removeEventById(EventId id) {
        return events.removeIf(event -> event.getId().value().equals(id.value()));
    }
}
