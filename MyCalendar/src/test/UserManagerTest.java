import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.UserManager;


import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    private UserManager userManager;
    private TestUserOutput output;

    @BeforeEach
    void setUp() {
        output = new TestUserOutput();
    }

    private UserManager createUserManagerWithInput(String input) {
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        return new UserManager(scanner, output);
    }

    @Test
    void shouldStartWithNoCurrentUser() {
        userManager = createUserManagerWithInput("");
        assertFalse(userManager.isLoggedIn());
        assertNull(userManager.getCurrentUser());
    }

    @Test
    void shouldLoginSuccessfully() {
        // Préparer l'enregistrement
        String registerInput = "testUser\npassword123\npassword123\n";
        userManager = createUserManagerWithInput(registerInput);
        userManager.register();

        // Préparer la connexion
        String loginInput = "testUser\npassword123\n";
        userManager = createUserManagerWithInput(loginInput);
        userManager.login();

        assertTrue(userManager.isLoggedIn());
        assertEquals("testUser", userManager.getCurrentUser().getUsername().getValue());
        assertTrue(output.getLastMessage().contains("Connexion réussie"));
    }

    @Test
    void shouldFailLoginWithWrongCredentials() {
        String input = "wrongUser\nwrongPass\n";
        userManager = createUserManagerWithInput(input);
        userManager.login();

        assertFalse(userManager.isLoggedIn());
        assertTrue(output.getLastMessage().contains("Identifiants incorrects"));
    }

    @Test
    void shouldRegisterNewUser() {
        String input = "newUser\npassword123\npassword123\n";
        userManager = createUserManagerWithInput(input);
        userManager.register();

        assertTrue(output.getLastMessage().contains("Compte créé avec succès"));
    }

}