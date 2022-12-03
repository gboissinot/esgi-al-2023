package fr.esgi.al.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
