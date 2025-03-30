package event.types;

import event.Event;
import event.primitives.DurationEvent;
import event.primitives.OwnerEvent;
import event.primitives.TitleEvent;

import java.time.LocalDateTime;

public class Birthday extends Event {
    public Birthday(TitleEvent title, OwnerEvent owner, LocalDateTime beginning, DurationEvent duration) {
        super(title, owner, beginning, duration);
    }

    @Override
    public String description() {
        return "Anniversaire : " + getTitle() + " le " + getBeginning().toLocalDate();
    }

    @Override
    public boolean isInPeriod(LocalDateTime first, LocalDateTime end) {
        LocalDateTime birthday = getBeginning();
        return !birthday.isBefore(first) && !birthday.isAfter(end);
    }
}