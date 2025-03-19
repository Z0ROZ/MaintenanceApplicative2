import Event.Event;
import calendar.Calendar;
import java.time.LocalDateTime;
import java.util.List;


public class CalendarManager {

    private final Calendar calendar;

    public CalendarManager() {
        this.calendar = new Calendar();
    }


    public void ajouterEvenement(Event evenement) {
        calendar.ajouterEvenement(evenement);
    }


    public List<Event> evenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return calendar.evenementsDansPeriode(debut, fin);
    }


    public void afficherEvenements() {
        calendar.afficherEvenements();
    }
}

