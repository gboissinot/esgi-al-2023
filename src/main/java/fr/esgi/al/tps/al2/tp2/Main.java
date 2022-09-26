package fr.esgi.al.tps.al2.tp2;

public class Main {

    public static void main(String[] args) {
        CommandBus commandBus = new DefaultCommandBus();
        commandBus.dispatch(new ChangeUserAddressCommand());
        commandBus.dispatch(() -> "Create USER");
        commandBus.dispatch(() -> "Change Address USER");
        commandBus.dispatch(() -> "Change RIB USER");
        commandBus.dispatch(() -> "Delete USER");
    }
}
