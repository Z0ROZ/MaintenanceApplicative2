package calendar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import event.Event;

public class Calendar {

    private final List<Event> evenements;

    public Calendar() {
        this.evenements = new ArrayList<>();
    }

    public void ajouterEvenement(Event evenement) {
        evenements.add(evenement);
    }

    public List<Event> evenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return evenements.stream()
                .filter(event -> event.isInPeriod(debut, fin))
                .collect(Collectors.toList());
    }

    public void afficherEvenements() {
        evenements.forEach(e -> System.out.println(e.description()));
    }

}
