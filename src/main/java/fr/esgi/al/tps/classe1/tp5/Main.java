package fr.esgi.al.tps.classe1.tp5;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        final MyService1 service1 = ServiceLocator1.get("service1");
        service1.myMethod1();

        var myService2 = ServiceLocator2.get(MyService2.class);
        myService2.myMethod2();

        final Optional<MyService1> myService3WithOptional = ServiceLocator3.get(MyService1.class);
        myService3WithOptional.ifPresent(MyService1::myMethod1);
    }
}
