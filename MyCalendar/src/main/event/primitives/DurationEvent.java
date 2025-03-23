package event.primitives;

public record DurationEvent(int minutes) {
    public DurationEvent {
        if (minutes <= 0) {
            throw new IllegalArgumentException("La durée doit être positive");
        }
    }
}
