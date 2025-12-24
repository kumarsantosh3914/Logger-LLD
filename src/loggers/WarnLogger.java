package loggers;

public class WarnLogger extends AbstractLogger {

    public WarnLogger() {
        super(enums.LogLevel.WARN);
    }

    @Override
    protected void write(String message) {
        System.out.println("[WARN]: " + message);
    }
}
