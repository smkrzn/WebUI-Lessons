package org.example.Lesson4;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void square() {
        Triangle triangle = new Triangle();
        Double actual = triangle.square(3,4,5);
        Double expected = 6.0;
        assertEquals(actual,expected);
    }
}