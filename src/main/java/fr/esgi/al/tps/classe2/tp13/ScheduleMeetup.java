package fr.esgi.al.tps.classe2.tp13;

import java.time.LocalDateTime;

final class ScheduleMeetup {

    public final String title;
    public final LocalDateTime date;

    public ScheduleMeetup(String title, LocalDateTime date) {
        this.title = title;
        this.date = date;
    }
}
