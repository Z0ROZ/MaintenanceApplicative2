package event;

import event.primitives.*;
import java.time.LocalDateTime;

public class Periodique extends Event {
    protected final FrequenceJours frequence;

    public Periodique(TitreEvenement titre, ProprietaireEvenement proprietaire, LocalDateTime dateDebut, DureeEvenement duree, FrequenceJours frequence) {
        super(titre, proprietaire, dateDebut, duree);
        this.frequence = frequence;
    }


    @Override
    public String description() {
        return "Événement périodique : " + titre + " tous les " + frequence + " jours";
    }


    public boolean isInPeriod(LocalDateTime debut, LocalDateTime fin) {
        LocalDateTime temp = this.dateDebut;
        while (temp.isBefore(fin)) {
            if (!temp.isBefore(debut)) {
                return true;
            }
            temp = temp.plusDays(this.frequence.jours());
        }
        return false;
    }
}
