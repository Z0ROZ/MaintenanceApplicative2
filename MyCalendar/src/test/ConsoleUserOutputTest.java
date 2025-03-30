import org.junit.jupiter.api.Test;
import user.message.ConsoleUserOutput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ConsoleUserOutputTest {
    @Test
    void shouldDisplayMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ConsoleUserOutput output = new ConsoleUserOutput();
        output.displayMessage("Test message");

        assertEquals("Test message" + System.lineSeparator(), outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void shouldDisplayError() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));

        ConsoleUserOutput output = new ConsoleUserOutput();
        output.displayError("Test error");

        assertEquals("Erreur: Test error" + System.lineSeparator(), errContent.toString());
        System.setErr(System.err);
    }
}