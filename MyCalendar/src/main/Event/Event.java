package Event;

import Event.primitives.DureeEvenement;
import Event.primitives.ProprietaireEvenement;
import Event.primitives.TitreEvenement;

import java.time.LocalDateTime;

public abstract class Event {
    protected final TitreEvenement titre;
    protected final ProprietaireEvenement proprietaire;
    protected final LocalDateTime dateDebut;
    protected final DureeEvenement duree;

    public Event(TitreEvenement titre, ProprietaireEvenement proprietaire, LocalDateTime dateDebut, DureeEvenement duree) {
        this.titre = titre;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }


    public abstract String description();

    public abstract boolean isInPeriod(LocalDateTime debut, LocalDateTime fin);

}
