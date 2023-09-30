package fr.esgi.al.tps.oop.tp5;

public class Main {
    public static void main(String[] args) throws Exception {

//        Sample reflexion
//        final Constructor<?>[] constructors = ServiceLocator.class.getDeclaredConstructors();
//        for (Constructor<?> constructor : constructors) {
//            constructor.setAccessible(true);
//            constructor.newInstance(new Object[0]);
//        }

        final Logger logger = ServiceLocator.get("logger");
        System.out.println(logger);
    }
}
