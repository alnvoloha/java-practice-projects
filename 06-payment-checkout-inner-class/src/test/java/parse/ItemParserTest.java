package parse;

import entity.Payment;
import exception.InvalidItemException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ItemParserTest {

    @Test
    public void testParseShouldReturnCorrectItem() throws InvalidItemException {
        Payment payment = new Payment();
        Payment.Item item = ItemParser.parse("Молоко,2.5,3", payment);

        assertEquals(item.name(), "Молоко");
        assertEquals(item.price(), 2.5);
        assertEquals(item.quantity(), 3);
    }

    @Test(expectedExceptions = InvalidItemException.class)
    public void testParseShouldThrowForInvalidFormat() throws InvalidItemException {
        Payment payment = new Payment();
        ItemParser.parse("Молоко-2.5-3", payment); // неправильный разделитель
    }

    @Test(expectedExceptions = InvalidItemException.class)
    public void testParseShouldThrowForBadNumbers() throws InvalidItemException {
        Payment payment = new Payment();
        ItemParser.parse("Молоко,abc,3", payment);
    }

    @Test(expectedExceptions = InvalidItemException.class)
    public void testParseShouldThrowForEmptyString() throws InvalidItemException {
        Payment payment = new Payment();
        ItemParser.parse("   ", payment);
    }

    @Test(expectedExceptions = InvalidItemException.class)
    public void testParseShouldThrowForInvalidData() throws InvalidItemException {
        Payment payment = new Payment();
        ItemParser.parse(" , -1, 0", payment); // некорректные поля
    }
}
