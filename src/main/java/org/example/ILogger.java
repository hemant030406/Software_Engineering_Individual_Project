package org.example;

/**
 * Defines an interface for a generic logging mechanism, allowing for
 * dependency inversion.
 */
public interface ILogger {
    /**
     * Logs the given message.
     * @param message The message to be logged.
     */
    void log(String message);
}