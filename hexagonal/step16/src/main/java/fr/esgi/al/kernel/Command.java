package fr.esgi.al.kernel;

public interface Command {
    default String name(){
        return this.getClass().getSimpleName();
    }
}
