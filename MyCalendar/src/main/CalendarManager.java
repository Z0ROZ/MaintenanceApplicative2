import Event.Event;
import Event.Periodique;
import Event.RendezVous;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarManager {
    private final List<Event> evenements;

    public CalendarManager() {
        this.evenements = new ArrayList<>();
    }

    public void ajouterEvenement(Event evenement) {
        evenements.add(evenement);
    }

    public List<Event> evenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        List<Event> result = new ArrayList<>();

        for (Event e : evenements) {
            if (e instanceof Periodique ep) {
                LocalDateTime temp = ep.getDateDebut();
                while (temp.isBefore(fin)) {
                    if (!temp.isBefore(debut)) {
                        result.add(ep);
                        break;
                    }
                    temp = temp.plusDays(ep.getFrequence().jours());
                }
            } else if (!e.getDateDebut().isBefore(debut) &&
                    !e.getDateDebut().isAfter(fin)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean conflit(Event e1, Event e2) {
        if (e1 instanceof Periodique || e2 instanceof Periodique) {
            return false; // Exclusion des événements périodiques pour les conflits
        }

        LocalDateTime debut1 = e1.getDateDebut();
        LocalDateTime fin1 = debut1.plusMinutes(((RendezVous) e1).getDuree().minutes());

        LocalDateTime debut2 = e2.getDateDebut();
        LocalDateTime fin2 = debut2.plusMinutes(((RendezVous) e2).getDuree().minutes());

        return debut1.isBefore(fin2) && fin1.isAfter(debut2);
    }

    public void afficherEvenements() {
        evenements.forEach(e -> System.out.println(e.description()));
    }
}
