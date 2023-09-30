package fr.esgi.al.tps.oop.tp23;

public class MailListener implements Listener {
    @Override
    public void listenTo(Event event) {
        System.out.println("Send email");
    }
}
