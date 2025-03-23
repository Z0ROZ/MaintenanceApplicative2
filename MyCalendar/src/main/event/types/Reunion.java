package event;

import event.primitives.*;

import java.time.LocalDateTime;

public class Reunion extends Event {
    protected final PlaceEvent place;
    protected final ParticipantsEvent participants;


    public Reunion(TitleEvent title, OwnerEvent owner, LocalDateTime beginning, DurationEvent duration, PlaceEvent place, ParticipantsEvent participant) {
        super(title, owner, beginning, duration);
        this.place = place;
        this.participants = participant;
    }

    @Override
    public String description() {
        return "Réunion : " + getTitle() + " à " + place + " avec " + participants;
    }

    @Override
    public boolean isInPeriod(LocalDateTime beginning, LocalDateTime end) {
        return !getBeginning().isBefore(beginning) && !getBeginning().isAfter(end);
    }
}
