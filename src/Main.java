import loggers.AbstractLogger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static AbstractLogger getLoggerChain() {
        AbstractLogger debugLogger = new loggers.DebugLogger();
        AbstractLogger infoLogger = new loggers.InfoLogger();
        AbstractLogger warnLogger = new loggers.WarnLogger();
        AbstractLogger errorLogger = new loggers.ErrorLogger();
        AbstractLogger fatalLogger = new loggers.FatalLogger();

        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fatalLogger);

        return debugLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getLoggerChain();

        System.out.println("Logging DEBUG level message:");
        loggerChain.log(enums.LogLevel.DEBUG, "This is a DEBUG level message.");

        System.out.println("\nLogging INFO level message:");
        loggerChain.log(enums.LogLevel.INFO, "This is an INFO level message.");

        System.out.println("\nLogging WARN level message:");
        loggerChain.log(enums.LogLevel.WARN, "This is a WARN level message.");

        System.out.println("\nLogging ERROR level message:");
        loggerChain.log(enums.LogLevel.ERROR, "This is an ERROR level message.");

        System.out.println("\nLogging FATAL level message:");
        loggerChain.log(enums.LogLevel.FATAL, "This is a FATAL level message.");
    }
}