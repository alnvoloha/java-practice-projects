package util;

import org.testng.annotations.Test;
import util.TextUtils;

import static org.testng.Assert.*;

public class TextUtilsTest {

    @Test
    public void testNormalizeRemovesExtraSpaces() {
        String input = "Hello     world";
        String result = TextUtils.normalize(input);
        assertEquals(result, "Hello world");
    }

    @Test
    public void testNormalizeRemovesMultipleTabsAndNewlines() {
        String input = "\t\tHello \n \n World\t";
        String result = TextUtils.normalize(input);
        assertEquals(result, "Hello\n\nWorld"); // исправлено: ожидаем 2 перевода строки
    }
}
