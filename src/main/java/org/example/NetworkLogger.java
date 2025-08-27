package org.example;

/**
 * Simulates sending log messages over a network.
 */
public class NetworkLogger implements Logger {
    /**
     * Stores the host name.
     */
    private final String host;
    /**
     * Stores the port number.
     */
    private final int port;

    public NetworkLogger(final String inputHost, final int inputPort) {
        this.host = inputHost;
        this.port = inputPort;
    }

    @Override
    public void log(final String message) {
        // In a real app, this would use a socket to send data.
        System.out.println("NETWORK LOG to "
                + host + ":" + port + " -> " + message);
    }
}