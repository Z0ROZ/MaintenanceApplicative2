package event;

import event.primitives.DurationEvent;
import event.primitives.EventId;
import event.primitives.OwnerEvent;
import event.primitives.TitleEvent;

import java.time.LocalDateTime;

public abstract class Event {
    protected final EventId id;
    protected final TitleEvent title;
    protected final OwnerEvent owner;
    protected final LocalDateTime beginning;
    protected final DurationEvent duration;

    public Event(TitleEvent title, OwnerEvent owner, LocalDateTime beginning, DurationEvent duration) {
        this.id = EventId.generate();
        this.title = title;
        this.owner = owner;
        this.beginning = beginning;
        this.duration = duration;
    }

    public abstract String description();

    public abstract boolean isInPeriod(LocalDateTime beginning, LocalDateTime end);

    public boolean overlaps(Event other) {
        LocalDateTime thisEnd = this.beginning.plusMinutes(this.duration.minutes());
        LocalDateTime otherEnd = other.beginning.plusMinutes(other.duration.minutes());

        return !this.beginning.isAfter(otherEnd) && !thisEnd.isBefore(other.beginning);
    }

    public TitleEvent getTitle() {
        return title;
    }

    public LocalDateTime getBeginning() {
        return beginning;
    }

    public DurationEvent getDuration() {
        return duration;
    }

    public EventId getId() {
        return id;
    }

}
