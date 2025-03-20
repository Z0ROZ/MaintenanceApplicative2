package calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import event.Event;

public class Calendar {

    private final List<Event> events;

    public Calendar() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> eventInPeriod(LocalDateTime debut, LocalDateTime fin) {
        return events.stream()
                .filter(event -> event.isInPeriod(debut, fin))
                .collect(Collectors.toList());
    }

    public void displayEvents() {
        events.forEach(e -> System.out.println(e.description()));
    }

}
