package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * An implementation of Logger that appends messages to a specified file.
 */
public class FileLogger implements ILogger {
    /**
     * The path to the log file where messages will be written.
     */
    private final String filePath;

    /**
     * Constructs a new FileLogger.
     * @param logFilePath The path to the file where logs will be written.
     */
    public FileLogger(final String logFilePath) {
        this.filePath = logFilePath;
    }

    @Override
    public void log(final String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath, true))) {
            // Try writing to file
            out.println(message);
        } catch (IOException e) {
            // Give error if writing to file fails.
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}