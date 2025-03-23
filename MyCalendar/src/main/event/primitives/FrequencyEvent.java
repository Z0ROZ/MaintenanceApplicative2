package event.primitives;

public record FrequencyEvent(int frequencyDay) {

    public int day() {
        return frequencyDay;
    }
}
