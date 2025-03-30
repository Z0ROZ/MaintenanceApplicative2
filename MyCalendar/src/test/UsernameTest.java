import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.primitives.Username;

import static org.junit.Assert.assertThrows;

public class UsernameTest {
    @Test
    void shouldCreateValidUsername() {
        String validName = "testUser";
        Username username = Username.of(validName);
        Assertions.assertEquals(validName, username.getValue());
    }


    @Test
    void shouldThrowExceptionForEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> Username.of(""));
        assertThrows(IllegalArgumentException.class, () -> Username.of("   "));
        assertThrows(IllegalArgumentException.class, () -> Username.of(null));
    }
}