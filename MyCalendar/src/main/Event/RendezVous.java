package Event;

import Event.primitives.DureeEvenement;
import Event.primitives.ProprietaireEvenement;
import Event.primitives.TitreEvenement;

import java.time.LocalDateTime;

public class RendezVous extends Event {

    public RendezVous(TitreEvenement titre, ProprietaireEvenement proprietaire, LocalDateTime dateDebut, DureeEvenement duree) {
        super(titre, proprietaire, dateDebut, duree);
    }

    @Override
    public String description() {
        return "RDV : " + titre + " à " + dateDebut.toString();
    }
}
