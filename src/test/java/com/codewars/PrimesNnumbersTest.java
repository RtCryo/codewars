package com.codewars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesNnumbersTest {

    @Test
    @Timeout(16000)
    public void testFactors() {
        assertEquals(PrimesNnumbers.factors(86240),"(2**5)(5)(7**2)(11)");
        assertEquals(PrimesNnumbers.factors(7775460),"(2**2)(3**3)(5)(7)(11**2)(17)");
    }

    @Test
    @Timeout(value = 16000, unit = MILLISECONDS)
    public void testFactorsTime(){
        assertEquals(PrimesNnumbers.factors(933555431),"(7537)(123863)");
    }

}
