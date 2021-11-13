package org.bot;

import java.io.IOException;
import java.util.logging.*;

public class GlobalFileLogger {
    private final Logger logger = Logger.getLogger(GlobalFileLogger.class.getName());

    public GlobalFileLogger() {
        configureLogger();
    }

    static class FormatterForGlobalFileLogger extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + " " + record.getMessage() + "\n";
        }
    }

    private void configureLogger() {
        try {
            Handler fileHandler = new FileHandler("chat.log");
            fileHandler.setFormatter(new FormatterForGlobalFileLogger());
            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
        } catch (IOException ioException) {
            logger.warning("logger error");
        }
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logWarning(Exception exception) {
        logger.warning(exception.getMessage());
    }
}
