package loggers;

import enums.LogLevel;
import interfaces.Logger;

public abstract  class AbstractLogger implements Logger {

    protected LogLevel level;
    protected AbstractLogger nextLogger;

    public AbstractLogger(LogLevel level) {
        this.level = level;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void log(LogLevel level, String message) {
        if(level.getValue() <= this.level.getValue()) {
            write(message);
        }

        if(nextLogger != null) {
            nextLogger.log(level, message);
        }
    }

    protected abstract void write(String message);
}
