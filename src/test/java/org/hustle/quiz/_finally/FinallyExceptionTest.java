package org.hustle.quiz._finally;

import org.junit.jupiter.api.Test;

public class FinallyExceptionTest {
    @Test
    public void testStart() {
        String start = new Car().start();
        System.out.println(start);
    }
}
