package enums;

public enum LogLevel {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

/**
 * Implementing a modular logging framework in java.
 * Objectives: Design and implement a modular logging framework that supports multiple log
 * levels, adheres to design patterns, and allows extensibility for various output destinations.
 *
 * Requirements: Implement the following log levels, each represented as an enum:
 * DEBUG, INFO, WARN, ERROR, FATAL.
 * Each level should have an associated integer value to determine its severity.
 *
 * 2. Logger interface: Create a Logger interface with the following method:
 * void log(LogLevel level, String message);
 * this interface will be implemented by various concrete logger classes corresponding to each log level.
 *
 * 3. Concrete Logger classes: Implement concrete logger classes for each log level
 * DebugLogger, InfoLogger, WarnLogger, ErrorLogger, FatalLogger.
 * Each logger should check if it can handle the incoming log level. If it can, it processes
 * the log; otherwise, it passes the log to the next logger in the chain.
 *
 * 4. Chain of Responsibility Pattern: Implement the Chain of Responsibility design pattern to allow log messages
 * to pass through the chain of loggers until the appropriate logger handles it.
 */