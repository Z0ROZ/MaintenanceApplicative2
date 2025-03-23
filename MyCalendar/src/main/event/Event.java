package event;

import event.primitives.DurationEvent;
import event.primitives.OwnerEvent;
import event.primitives.TitleEvent;

import java.time.LocalDateTime;

public abstract class Event {
    protected final TitleEvent title;
    protected final OwnerEvent owner;
    protected final LocalDateTime beginning;
    protected final DurationEvent duration;

    public Event(TitleEvent title, OwnerEvent owner, LocalDateTime beginning, DurationEvent duration) {
        this.title = title;
        this.owner = owner;
        this.beginning = beginning;
        this.duration = duration;
    }

    public abstract String description();

    public abstract boolean isInPeriod(LocalDateTime beginning, LocalDateTime end);

    public TitleEvent getTitle() {
        return title;
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

}
