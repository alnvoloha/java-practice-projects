package util;

import entity.DigitStack;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberReverserTest {

    private final NumberReverser reverser = new NumberReverser();

    @Test
    public void testToStack_ReversedOrder() {
        DigitStack stack = reverser.toStack("123");
        Assert.assertEquals(stack.popDigit(), '3');
    }

    @Test
    public void testReverse_SimpleNumber() {
        DigitStack stack = reverser.toStack("456");
        String reversed = reverser.reverse(stack);
        Assert.assertEquals(reversed, "654");
    }

    @Test
    public void testReverse_EmptyStack() {
        DigitStack stack = new DigitStack();
        String reversed = reverser.reverse(stack);
        Assert.assertEquals(reversed, "");
    }
}
