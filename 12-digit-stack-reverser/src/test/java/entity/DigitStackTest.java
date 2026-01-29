package entity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DigitStackTest {

    @Test
    public void testPushAndPopDigit_Valid() {
        DigitStack stack = new DigitStack();
        stack.pushDigit('5');
        Assert.assertEquals(stack.popDigit(), '5');
    }

    @Test(expectedExceptions = java.util.NoSuchElementException.class)
    public void testPopDigit_EmptyStack_ThrowsException() {
        DigitStack stack = new DigitStack();
        stack.popDigit(); // должно выбросить исключение
    }

    @Test
    public void testIsEmpty_WhenNewStack() {
        DigitStack stack = new DigitStack();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty_AfterPush() {
        DigitStack stack = new DigitStack();
        stack.pushDigit('1');
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize_AfterPush() {
        DigitStack stack = new DigitStack();
        stack.pushDigit('1');
        stack.pushDigit('2');
        Assert.assertEquals(stack.size(), 2);
    }

    @Test
    public void testEquals_TwoIdenticalStacks() {
        DigitStack s1 = new DigitStack();
        DigitStack s2 = new DigitStack();
        s1.pushDigit('1');
        s2.pushDigit('1');
        Assert.assertEquals(s1, s2);
    }

    @Test
    public void testCompareTo_BasedOnSize() {
        DigitStack s1 = new DigitStack();
        DigitStack s2 = new DigitStack();
        s1.pushDigit('1');
        s1.pushDigit('2');
        s2.pushDigit('3');
        Assert.assertTrue(s1.compareTo(s2) > 0);
    }
}
