package fr.esgi.al.tps.oop.classe1.tp4;

import java.io.FileWriter;
import java.io.IOException;

final class FileLogger implements Logger {

    private final Formatter formatter;

    FileLogger(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void log(String message) {
        var formattedMessage = formatter.format(message);
        try {
            final FileWriter fileWriter = new FileWriter("classe1.log", true);
            fileWriter.append(formattedMessage);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
