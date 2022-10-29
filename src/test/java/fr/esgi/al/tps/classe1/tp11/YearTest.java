package fr.esgi.al.tps.classe1.tp11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class YearTest {

    @Test
    public void next() {
        var year = new Year(2022);
        year.next();
        Assertions.assertEquals(new Year(2022), year);
        Assertions.assertEquals(new Year(2023), year.next());
        year = year.next();
        Assertions.assertEquals(new Year(2023), year);
    }
}
