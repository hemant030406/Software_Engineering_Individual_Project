import org.example.FileLogger;
import org.example.ILogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class FileLoggerTest {

    // JUnit 5 provides and cleans up a temporary directory
    @TempDir
    Path tempDir;

    @Test
    void shouldWriteAndAppendLogMessagesToFile() throws IOException {
        Path logFile = tempDir.resolve("test.log");
        ILogger logger = new FileLogger(logFile.toString());
        String message1 = "First line.";
        String message2 = "Second line.";

        logger.log(message1);
        logger.log(message2);

        String fileContent = Files.readString(logFile);

        // Check that both messages are in the file in the correct order
        assertThat(fileContent)
                .contains(message1)
                .contains(message2)
                .startsWith(message1);
    }
}