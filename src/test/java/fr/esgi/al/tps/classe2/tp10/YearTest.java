package fr.esgi.al.tps.classe2.tp10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YearTest {

    @Test
    public void test(){
        Year year = new Year(2022);
        year.next();
        Assertions.assertEquals(new Year(2022),year);

        year=year.next();
        Assertions.assertEquals(new Year(2023),year);
    }
}
