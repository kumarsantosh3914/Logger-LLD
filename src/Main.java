import enums.LogLevel;
import factory.LoggerFactory;
import loggers.AbstractLogger;
import subscribers.ConsoleSubscriber;
import subscribers.FileSubscriber;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        AbstractLogger loggerChain = LoggerFactory.createLoggerChain();

        // Create subscribers
        ConsoleSubscriber consoleSubscriber = new ConsoleSubscriber();
        FileSubscriber fileSubscriber = new FileSubscriber("app_log_data.log");

        // Subscribe to all loggers in the chain
        loggerChain.subscribeToChain(consoleSubscriber);
        loggerChain.subscribeToChain(fileSubscriber);

        System.out.println("Logging DEBUG level message:");
        loggerChain.log(LogLevel.DEBUG, "This is a DEBUG level message.");

        System.out.println("\nLogging INFO level message:");
        loggerChain.log(LogLevel.INFO, "This is an INFO level message.");

        System.out.println("\nLogging WARN level message:");
        loggerChain.log(LogLevel.WARN, "This is a WARN level message.");

        System.out.println("\nLogging ERROR level message:");
        loggerChain.log(LogLevel.ERROR, "This is an ERROR level message.");

        System.out.println("\nLogging FATAL level message:");
        loggerChain.log(LogLevel.FATAL, "This is a FATAL level message.");
    }
}