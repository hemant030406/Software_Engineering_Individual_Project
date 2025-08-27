package org.example;

/**
 * UserService depends on the abstraction (Logger), not a concrete class.
 */
public class UserService {
    /**
     * A generic logger which can be of any type such as ConsoleLogger, FileLogger, NetworkLogger or NullLogger.
     */
    private final Logger logger; // Dependency is on the interface

    // The specific logger is "injected" from the outside.
    public UserService(final Logger inputLogger) {
        this.logger = inputLogger;
    }

    public void createUser(final String name) {
        // It uses the logger without knowing what kind it is.
        logger.log("Creating user: " + name);
    }
}