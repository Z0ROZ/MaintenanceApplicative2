package event.primitives;

public record FrequenceJours(int frequenceJours) {

    public int jours() {
        return frequenceJours;
    }
}
