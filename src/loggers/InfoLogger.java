package loggers;

import enums.LogLevel;

public class InfoLogger extends AbstractLogger {

    public InfoLogger() {
        super(LogLevel.DEBUG);
    }

    @Override
    protected void write(String message) {
        System.out.println("[INFO]: " + message);
    }
}