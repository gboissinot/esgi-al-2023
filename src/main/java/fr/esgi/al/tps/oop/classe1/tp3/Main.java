package fr.esgi.al.tps.oop.classe1.tp3;

public class Main {

    public static void main(String[] args) throws Exception {

//Sample Reflexion
//        final Constructor<?>[] constructors = ServiceLocator.class.getDeclaredConstructors();
//        for (Constructor<?> constructor : constructors) {
//            constructor.setAccessible(true);
//            constructor.newInstance(new Object[0]);
//        }

        MyService myService = new MyService(message -> System.out.println("[INLINE LOG] - " + message));
        myService.myMethod();
    }
}
