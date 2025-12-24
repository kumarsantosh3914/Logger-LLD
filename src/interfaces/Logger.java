package interfaces;

import enums.LogLevel;

public interface Logger {

    void log(LogLevel level, String message);
}
