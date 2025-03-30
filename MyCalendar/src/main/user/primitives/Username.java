package user.primitives;

import java.io.Serial;
import java.io.Serializable;

public final class Username implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String value;

    private Username(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom d'utilisateur ne peut pas être vide");
        }
        this.value = value;
    }

    public static Username of(String value) {
        return new Username(value);
    }

    public String getValue() {
        return value;
    }
}