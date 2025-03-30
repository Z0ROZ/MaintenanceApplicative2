package calendar;

import event.Event;
import event.primitives.EventId;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calendar {
    private final List<Event> events;
    private final CalendarOutput output;

    public Calendar() {
        this.events = new ArrayList<>();
        this.output = new CalendarOutput();
    }

    public void validateAndAddEvent(Event event) {
        List<Event> conflicts = findConflicts(event);
        conflicts.stream()
                .findAny()
                .ifPresentOrElse(
                        e -> conflicts.forEach(c -> System.out.println("- " + c.description())),
                        () -> {
                            events.add(event);
                            output.eventAdded();
                        }
                );
    }

    private List<Event> findConflicts(Event newEvent) {
        return events.stream()
                .filter(existingEvent -> existingEvent.overlaps(newEvent))
                .collect(Collectors.toList());
    }

    public List<Event> eventInPeriod(LocalDateTime beginning, LocalDateTime end) {
        return events.stream()
                .filter(event -> event.isInPeriod(beginning, end))
                .collect(Collectors.toList());
    }

    public void displayEvents() {
        events.stream()
                .map(Event::description)
                .forEach(System.out::println);
    }

    public void removeEventAndNotify(EventId id) {
        boolean removed = events.removeIf(event -> event.getId().value().equals(id.value()));
        if (removed) {
            output.eventRemoved();
        } else {
            output.eventNotFound();
        }
    }
}
