package fr.esgi.al.tps.oop.classe1.tp1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Value from Zip code : " + ZipCode.of("94140").code());
        System.out.println("Department from Zip : " + ZipCode.of("94140").department());

        ZipCode zipCode1 = ZipCode.of("94140");
        ZipCode zipCode2 = ZipCode.of("94140");
        System.out.println(zipCode1 == zipCode2); //true because the ZipCode is cached. No new instance is created
        System.out.println(zipCode1.equals(zipCode2)); //true

        final Map<ZipCode, String> zipCodeMap = Map.of(
                ZipCode.of("94140"), "94140",
                ZipCode.of("75000"), "75000");

        final String value = zipCodeMap.get(ZipCode.of("94140"));
        System.out.println(value); // Not null because the hashCode() and equals() of ZipCode has been overridden
    }
}
