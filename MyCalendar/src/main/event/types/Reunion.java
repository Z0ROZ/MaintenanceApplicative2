package event.types;

import event.primitives.*;

import java.time.LocalDateTime;
import event.Event;


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
        return "Réunion : " + getTitle().valeur() + " à " + place + " avec " + participants;
    }

    @Override
    public boolean isInPeriod(LocalDateTime beginning, LocalDateTime end) {
        return !getBeginning().isBefore(beginning) && !getBeginning().isAfter(end);
    }
}
