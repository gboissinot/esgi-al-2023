package fr.esgi.al.tps.oop.classe2.tp5;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws Exception {

        final Constructor<?>[] constructors = ServiceLocator.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            constructor.newInstance(new Object[0]);
        }

        final Logger logger = ServiceLocator.get("logger");
        System.out.println(logger);
    }
}
