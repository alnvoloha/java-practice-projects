package task;

import exception.InvalidTextException;
import org.testng.annotations.Test;
import task.LetterNumberFormatter;

import static org.testng.Assert.*;

public class LetterNumberFormatterTest {

    @Test
    public void testFormatWithStringMethodsValid() {
        String result = LetterNumberFormatter.formatWithStringMethods("abc");
        assertEquals(result, "a  b  c\n1  2  3");
    }

    @Test(expectedExceptions = InvalidTextException.class)
    public void testFormatWithStringMethodsInvalid() {
        LetterNumberFormatter.formatWithStringMethods("   ");
    }

    @Test
    public void testFormatWithStreamsValid() {
        String result = LetterNumberFormatter.formatWithStreams("xyz");
        assertEquals(result, "x  y  z\n24  25  26");
    }

    @Test(expectedExceptions = InvalidTextException.class)
    public void testFormatWithStreamsInvalid() {
        LetterNumberFormatter.formatWithStreams(null);
    }
}
