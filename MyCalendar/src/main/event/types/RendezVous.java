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
        return "RDV : " + getTitle() + " à " + getBeginning();
    }

    @Override
    public boolean isInPeriod(LocalDateTime first, LocalDateTime end) {
        return !beginning.isBefore(first) && !beginning.isAfter(end);
    }
}
