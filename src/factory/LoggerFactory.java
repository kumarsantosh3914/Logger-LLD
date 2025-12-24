package factory;

import loggers.AbstractLogger;

public class LoggerFactory {

    public static AbstractLogger createLoggerChain() {
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
}
