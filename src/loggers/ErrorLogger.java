package loggers;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        super(enums.LogLevel.ERROR);
    }

    @Override
    protected void write(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
