package exception;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InvalidItemExceptionTest {

    @Test
    public void testConstructorWithMessage() {
        InvalidItemException ex = new InvalidItemException("Ошибка товара");
        assertEquals(ex.getMessage(), "Ошибка товара");
    }

    @Test
    public void testConstructorWithMessageAndCause() {
        Throwable cause = new RuntimeException("Внутренняя ошибка");
        InvalidItemException ex = new InvalidItemException("Ошибка товара", cause);
        assertEquals(ex.getMessage(), "Ошибка товара");
        assertEquals(ex.getCause(), cause);
    }
}
