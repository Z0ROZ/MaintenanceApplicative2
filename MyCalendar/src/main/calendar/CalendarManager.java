package calendar;

import event.Event;

import java.time.LocalDateTime;


public class CalendarManager {

    private final Calendar calendar;

    public CalendarManager() {
        this.calendar = new Calendar();
    }


    public void ajouterEvenement(Event evenement) {
        calendar.ajouterEvenement(evenement);
    }


    public void evenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        calendar.evenementsDansPeriode(debut, fin);
    }

    public void afficherEvenements() {
        calendar.afficherEvenements();
    }
}

