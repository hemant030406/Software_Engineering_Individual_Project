package org.example;

/**
 * The main class for this application.
 * It serves as the entry point to print a welcome message and a numbered list.
 */
public class Main {
    /**
     * The primary entry point for the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(final String[] args) {
        final Logger consoleLogger = new ConsoleLogger();
        consoleLogger.log("Hello World!");

        final Logger fileLogger = new FileLogger("./fileLog.txt");
        fileLogger.log("Hello World!");

        final Logger networkLogger = new NetworkLogger("log.server.com", 8000);
        networkLogger.log("Hello World!");

        final Logger nullLogger = new NullLogger();
        nullLogger.log("Hello World!");
    }
}