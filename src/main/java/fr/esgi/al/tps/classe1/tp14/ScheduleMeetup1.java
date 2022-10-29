package fr.esgi.al.tps.classe1.tp14;

import java.time.LocalDateTime;

//DTO
public class ScheduleMeetup1 {

    private String title;
    private LocalDateTime createdDate;

    public ScheduleMeetup1() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
