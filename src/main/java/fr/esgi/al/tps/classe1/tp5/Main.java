package fr.esgi.al.tps.classe1.tp5;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        final MyService1 service1 = ServiceLocator.get("service1");
        service1.myMethod1();


        var myService2 = ServiceLocator2.get(MyService2.class);
        myService2.myMethod2();

        final Optional<MyService1> myService1Optional = ServiceLocator3.get(MyService1.class);
        myService1Optional.ifPresent(MyService1::myMethod1);
    }
}
