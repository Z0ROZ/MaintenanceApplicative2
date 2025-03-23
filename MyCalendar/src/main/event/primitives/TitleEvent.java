package event.primitives;

public record TitleEvent(String valeur) {
    public TitleEvent {
        if (valeur == null || valeur.isBlank()) {
            throw new IllegalArgumentException("Il doit y avoir un titre pour l'evenement");        }
    }

}
