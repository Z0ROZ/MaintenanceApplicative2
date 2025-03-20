package event;

import event.primitives.DureeEvenement;
import event.primitives.ProprietaireEvenement;
import event.primitives.TitreEvenement;

import java.time.LocalDateTime;

public class RendezVous extends Event {

    public RendezVous(TitreEvenement titre, ProprietaireEvenement proprietaire, LocalDateTime dateDebut, DureeEvenement duree) {
        super(titre, proprietaire, dateDebut, duree);
    }

    @Override
    public String description() {
        return "RDV : " + titre + " à " + dateDebut.toString();
    }

    @Override
    public boolean isInPeriod(LocalDateTime debut, LocalDateTime fin) {
        return !dateDebut.isBefore(debut) && !dateDebut.isAfter(fin);
    }
}
