package event.types;

import event.primitives.DurationEvent;
import event.primitives.OwnerEvent;
import event.primitives.TitleEvent;
import event.Event;


import java.time.LocalDateTime;

public class RendezVous extends Event {

    public RendezVous(TitleEvent title, OwnerEvent owner, LocalDateTime beginning, DurationEvent duration) {
        super(title, owner, beginning, duration);
    }

    @Override
    public String description() {
        return String.format("[%s] RDV: %s le %s à %s (durée: %d min)",
                getId().value(),
                getTitle().valeur(),
                getBeginning().toLocalDate(),
                getBeginning().toLocalTime(),
                getDuration().minutes()
        );
    }

    @Override
    public boolean isInPeriod(LocalDateTime first, LocalDateTime end) {
        return !beginning.isBefore(first) && !beginning.isAfter(end);
    }
}
