package fr.esgi.al.tps.tp4;

import fr.esgi.al.tps.tp3.Logger;

import java.io.FileWriter;
import java.io.IOException;

final class FileLogger implements Logger {

    private final Formatter formatter;

    public FileLogger(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void log(String message) {
        var formattedMessage = formatter.format(message);
        try {
            FileWriter fileWriter = new FileWriter("toto.log", true);
            fileWriter.append(formattedMessage);
            fileWriter.append("\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
