package fr.esgi.al.tps.classe1.tp14;

import java.time.LocalDateTime;

//DTO
public class ScheduleMeetupGeneration3 {

    public final String title;
    public final LocalDateTime createdDate;

    public ScheduleMeetupGeneration3(String title, LocalDateTime createdDate) {
        this.title = title;
        this.createdDate = createdDate;
    }
}
