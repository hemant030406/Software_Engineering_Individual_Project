package org.example;

/**
 * A Null Logger used when logging output not desired.
 */
public class NullLogger implements ILogger {
    @Override
    public void log(final String message) {
        // Intentionally left empty.
    }
}