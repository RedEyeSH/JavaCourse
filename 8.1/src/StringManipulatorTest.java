import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {
    private final StringManipulator stringManipulator = new StringManipulator();

    @Test
    void testConcatenate() {
        assertEquals("HelloWorld", stringManipulator.concatenate("Hello", "World"));
    }

    @Test
    void testFindLength() {
        assertEquals(6, stringManipulator.findLength("Length"));
    }

    @Test
    void testConvertToUpperCase() {
        assertEquals("UPPERCASE", stringManipulator.convertToUpperCase("uppercase"));
    }

    @Test
    void testConvertToLowerCase() {
        assertEquals("lowercase", stringManipulator.convertToLowerCase("Lowercase"));
    }

    @Test
    void testContainsSubstring() {
        assertTrue(stringManipulator.containsSubstring("subString", "sub"));
    }
}
