package event.primitives;

import java.util.List;

public record ParticipantsEvent(List<String> participants) {

    @Override
    public String toString() {
        return String.join(", ", participants);
    }
}

