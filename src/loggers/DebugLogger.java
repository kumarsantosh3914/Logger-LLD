package loggers;

import enums.LogLevel;

public class DebugLogger extends AbstractLogger {

    public DebugLogger() {
        super(LogLevel.DEBUG);
    }

    @Override
    protected void write(String message) {
        System.out.println("[DEBUG]: " + message);
    }
}
