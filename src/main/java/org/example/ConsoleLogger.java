package org.example;

/**
 * An implementation of Logger that prints messages to the console.
 */
public class ConsoleLogger implements ILogger {
    @Override
    public void log(final String message) {
        System.out.println(message);
    }
}