package Event.primitives;

public record TitreEvenement(String valeur) {
    public TitreEvenement {
        if (valeur == null || valeur.isBlank()) {
            throw new IllegalArgumentException("Il doit y avoir un titre pour l'evenement");        }
    }
}
