package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void hello() {
        String actualResult = Main.hello();
        Assertions.assertEquals("Hello world!", actualResult, "Check 'Hello world!'");
    }
}