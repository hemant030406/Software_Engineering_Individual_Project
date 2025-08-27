import org.example.ILogger;
import org.example.NullLogger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NullLoggerTest {
    @Test
    void logShouldDoNothingAndNotThrowException() {
        ILogger logger = new NullLogger();

        // The test confirms that calling log() is safe and does not cause an error.
        assertDoesNotThrow(() -> logger.log("This message should be ignored."));
    }
}