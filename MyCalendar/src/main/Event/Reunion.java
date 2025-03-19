package Event;

import Event.primitives.*;

import java.time.LocalDateTime;

public class Reunion extends Event {
    protected final LieuEvenement lieu;
    protected final ParticipantsEvenement participants;


    public Reunion(TitreEvenement titre, ProprietaireEvenement proprietaire, LocalDateTime dateDebut, DureeEvenement duree, LieuEvenement lieu, ParticipantsEvenement participant) {
        super(titre, proprietaire, dateDebut, duree);
        this.lieu = lieu;
        this.participants = participant;
    }

    @Override
    public String description() {
        return "Réunion : " + titre + " à " + lieu + " avec " + participants;
    }

    @Override
    public boolean isInPeriod(LocalDateTime debut, LocalDateTime fin) {
        return !dateDebut.isBefore(debut) && !dateDebut.isAfter(fin);
    }
}
