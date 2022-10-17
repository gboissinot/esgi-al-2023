package fr.esgi.al.tps.classe2.tp13;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        ScheduleMeetup scheduleMeetup = new ScheduleMeetup("My ESGI Event", LocalDateTime.now());
        System.out.println("EVENT TITLE: " + scheduleMeetup.title);
    }
}
