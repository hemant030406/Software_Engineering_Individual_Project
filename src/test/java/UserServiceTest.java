import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This test uses concrete Logger implementations to verify the behavior of UserService.
 */
class UserServiceTest {
    private final String userName = "John Smith";
    private final String expectedLogMessage = "Creating user: " + userName;

    // For capturing console output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // Redirect System.out to byte array stream before each test
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        // Restore original System.out after each test
        System.setOut(originalOut);
    }

    @Test
    void createUserWithConsoleLogger() {
        Logger logger = new ConsoleLogger();
        UserService userService = new UserService(logger);
        userService.createUser(userName);

        assertEquals(expectedLogMessage, outContent.toString().trim());
    }

    @Test
    void createUserWithFileLogger(@TempDir Path tempDir) throws IOException {
        Path logFile = tempDir.resolve("test.log");
        Logger logger = new FileLogger(logFile.toString());
        UserService userService = new UserService(logger);

        userService.createUser(userName);
        userService.createUser(userName);

        String fileContent = Files.readString(logFile);

        assertThat(fileContent)
                .contains(expectedLogMessage)
                .contains(expectedLogMessage)
                .startsWith(expectedLogMessage);
    }

    @Test
    void createUserWithNetworkLogger(){
        Logger logger = new NetworkLogger("log.server.com", 5000);
        UserService userService = new UserService(logger);

        userService.createUser(userName);

        assertThat(outContent.toString().trim())
                .isEqualTo("NETWORK LOG to log.server.com:5000 -> " + expectedLogMessage);
    }

    @Test
    void createUserWithNullLogger() {
        Logger nullLogger = new NullLogger();
        UserService userService = new UserService(nullLogger);

        assertDoesNotThrow(() -> userService.createUser(userName));
    }
}