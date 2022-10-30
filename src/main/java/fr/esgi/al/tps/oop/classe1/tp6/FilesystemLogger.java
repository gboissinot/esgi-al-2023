package fr.esgi.al.tps.oop.classe1.tp6;

import java.io.FileWriter;
import java.io.IOException;

final class FilesystemLogger implements Logger {
    private final String logFilePath;

    public FilesystemLogger(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    @Override
    public void log(String message) {
        try {
            FileWriter fileWriter = new FileWriter(logFilePath, true);
            fileWriter.append(message);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
