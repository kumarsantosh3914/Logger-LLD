package loggers;

public class FatalLogger extends AbstractLogger {

    public FatalLogger() {
        super(enums.LogLevel.FATAL);
    }

    @Override
    protected void write(String message) {
        System.out.println("[FATAL]: " + message);
    }
}
