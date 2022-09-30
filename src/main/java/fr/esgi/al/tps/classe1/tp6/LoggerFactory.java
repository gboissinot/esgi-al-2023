package fr.esgi.al.tps.classe1.tp6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

final class LoggerFactory {

    private LoggerFactory() {
        throw new AssertionError();
    }

    public static Logger createConsoleLogger() {
        return new ConsoleLogger();
    }

    public static Logger createFileLogger(String logFilePath) {

        Path filePath = Path.of(logFilePath);
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return new FilesystemLogger(logFilePath);
    }
}
