package event.primitives;


import java.util.UUID;

public record EventId(String value) {
    public EventId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("L'identifiant ne peut pas être vide");
        }
    }

    public static EventId generate() {
        return new EventId(UUID.randomUUID().toString());
    }
}
