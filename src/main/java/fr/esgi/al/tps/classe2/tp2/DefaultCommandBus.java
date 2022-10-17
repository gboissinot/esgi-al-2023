package fr.esgi.al.tps.classe2.tp2;


public class DefaultCommandBus implements CommandBus {
    @Override
    public void execute(Command command) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
