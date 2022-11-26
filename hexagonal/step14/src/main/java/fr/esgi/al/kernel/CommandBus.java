package fr.esgi.al.kernel;

public interface CommandBus<C extends Command<C>> {
    <R> R post(C command);

    <R> void register(Class<C> commandClass, CommandHandler<C, R> commandHandler);
}
