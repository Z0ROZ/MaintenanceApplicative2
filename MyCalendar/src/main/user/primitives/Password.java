package user.primitives;

import java.io.Serial;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Password implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String hashedValue;

    private Password(String hashedValue) {
        if (hashedValue == null || hashedValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Le mot de passe ne peut pas être vide");
        }
        this.hashedValue = hashedValue;
    }


    public static Password fromPlainText(String plainText) {
        return new Password(hashPassword(plainText));
    }


    public boolean matches(String plainText) {
        return this.hashedValue.equals(hashPassword(plainText));
    }


    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erreur lors du hashage", e);
        }
    }
}