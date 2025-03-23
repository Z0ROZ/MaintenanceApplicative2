package event.primitives;

public record PlaceEvent(String valeur) {
    public PlaceEvent {
        if (valeur == null || valeur.isBlank()) {
            throw new IllegalArgumentException("Le lieu ne peut pas être vide");
        }
    }
}
