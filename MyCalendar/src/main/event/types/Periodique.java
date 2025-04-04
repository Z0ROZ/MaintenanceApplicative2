package event.types;

import event.primitives.*;
import event.Event;

import java.time.LocalDateTime;

public class Periodique extends Event {
    protected final FrequencyEvent frequency;

    public Periodique(TitleEvent titre, OwnerEvent owner, LocalDateTime beginning, DurationEvent duration, FrequencyEvent frequency) {
        super(titre, owner, beginning, duration);
        this.frequency = frequency;
    }


    @Override
    public String description() {
        return String.format("[%s] Périodique: %s | Fréquence: tous les %d jours | Début: %s",
                getId().value(),
                getTitle().valeur(),
                frequency.day(),
                getBeginning().toLocalDate()
        );
    }


    public boolean isInPeriod(LocalDateTime beginning, LocalDateTime end) {
        LocalDateTime temp = getBeginning();
        while (temp.isBefore(end)) {
            if (!temp.isBefore(beginning)) {
                return true;
            }
            temp = temp.plusDays(this.frequency.day());
        }
        return false;
    }
}
