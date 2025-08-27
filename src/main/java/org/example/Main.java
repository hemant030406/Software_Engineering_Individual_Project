package org.example;

/**
 * The main class for this application.
 * It serves as the entry point to print a welcome message and a numbered list.
 */
public class Main {
    /**
     * The primary entry point for the application.
     * It shows the dependency inversion principle.
     * The userService doesn't need to know the type of the logger,
     * it's implementation doesn't need to change based on the logger type.
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(final String[] args) {
        Logger logger = new ConsoleLogger();
        UserService userService = new UserService(logger);
        userService.createUser("JOE");

        logger = new FileLogger("./fileLog.txt");
        userService = new UserService(logger);
        userService.createUser("JOE");

        final int port = 8000;
        logger = new NetworkLogger("log.server.com", port);
        userService = new UserService(logger);
        userService.createUser("JOE");

        logger = new NullLogger();
        userService = new UserService(logger);
        userService.createUser("JOE");
    }
}