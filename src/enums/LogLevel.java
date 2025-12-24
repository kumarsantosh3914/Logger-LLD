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

/***
 * 5. Add new design pattern: Publisher-Subscriber Pattern
 * Implement the Publisher-Subscriber (Observer) design pattern to allow multiple
 * subscribers to receive log messages.
 *
 * - Publisher Interface:
 * > void subscribe(Subscriber subscriber);
 * > void unsubscribe(Subscriber subscriber);
 * > void notifySubscribers(String message);
 *
 * - Subscriber Interface:
 * > void update(String message);
 *
 * - Concrete Subscribers:
 *   > ConsoleSubscriber: Outputs logs to the console.
 *   > FileSubscriber: Writes logs to a file.
 *
 * 6. Logger Factory: Implement a LoggerFactory class to construct the chain of loggers and return the head
 *    of the chain. This promotes loose coupling and adherence to the Factory design pattern.
 *
 * 7. Main Application: Create a Main class to demonstrate the functionality:
 *    - Instantiate the logger chain using LoggerFactory.
 *    - Create instances of ConsoleSubscriber and FileSubscriber.
 *    - Subscribe these subscribers to the publisher.
 *    - Log messages at various levels to demonstrate the flow through the chain and the notification of subscribers.
 */