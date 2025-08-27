import org.example.ConsoleLogger;
import org.example.ILogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleLoggerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        // Redirect System.out to capture console output
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        // Restore original System.out
        System.setOut(originalOut);
    }

    @Test
    void shouldLogMessageToConsole() {
        ILogger logger = new ConsoleLogger();
        String message = "This is a test message.";

        logger.log(message);

        // Assert that the captured output matches the message
        assertThat(outContent.toString().trim()).isEqualTo(message);
    }
}