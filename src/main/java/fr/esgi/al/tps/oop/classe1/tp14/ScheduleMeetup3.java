package fr.esgi.al.tps.oop.classe1.tp14;

import java.time.LocalDateTime;

//DTO
final class ScheduleMeetup3 {

    public final String title;
    public final LocalDateTime createdDate;

    public ScheduleMeetup3(String title, LocalDateTime createdDate) {
        this.title = title;
        this.createdDate = createdDate;
    }
}
