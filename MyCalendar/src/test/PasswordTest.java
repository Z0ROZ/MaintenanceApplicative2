import org.junit.jupiter.api.Test;
import user.primitives.Password;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {
    @Test
    void shouldCreateValidPassword() {
        String validPassword = "password123";
        Password password = Password.fromPlainText(validPassword);
        assertTrue(password.matches(validPassword));
    }



    @Test
    void shouldThrowExceptionForNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> Password.fromPlainText(null));
    }

    @Test
    void toStringShouldMaskPassword() {
        Password password = Password.fromPlainText("secretPassword");
        assertEquals("*************", password.toString());
    }
}