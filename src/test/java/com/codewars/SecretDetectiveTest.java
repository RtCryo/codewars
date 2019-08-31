package com.codewars;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecretDetectiveTest {

    private SecretDetective detective;

    @Before
    public void setup() {
        detective = new SecretDetective();
    }

    @Test
    public void secret1() {
        char[][] triplets = {
                {'t','u','p'},
                {'w','h','i'},
                {'t','s','u'},
                {'a','t','s'},
                {'h','a','p'},
                {'t','i','s'},
                {'w','h','s'}
        };
        assertEquals("whatisup", detective.recoverSecret(triplets));
    }

}
