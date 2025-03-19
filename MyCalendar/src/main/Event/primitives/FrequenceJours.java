package Event.primitives;

public record FrequenceJours(int frequenceJours) {

    // La méthode qui retourne la valeur de la fréquence en jours
    public int jours() {
        return frequenceJours;
    }
}
