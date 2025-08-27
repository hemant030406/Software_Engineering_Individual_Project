import org.example.ILogger;
import org.example.NetworkLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

class NetworkLoggerTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void shouldFormatLogMessageWithHostAndPort() {
        ILogger logger = new NetworkLogger("log.server.com", 5000);
        logger.log("User logged in");

        assertThat(out.toString().trim())
                .isEqualTo("NETWORK LOG to log.server.com:5000 -> User logged in");
    }
}