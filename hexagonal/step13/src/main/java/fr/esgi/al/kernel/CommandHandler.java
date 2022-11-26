package fr.esgi.al.kernel;

public interface CommandHandler<C extends Command<C>, R> {
    R handle(C command);
}
