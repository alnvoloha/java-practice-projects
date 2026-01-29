package valid;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ItemValidatorTest {

    @Test
    public void testIsValidShouldReturnTrueForCorrectInput() {
        assertTrue(ItemValidator.isValid("Молоко", 2.5, 1));
    }

    @Test
    public void testIsValidShouldReturnFalseForNegativePrice() {
        assertFalse(ItemValidator.isValid("Молоко", -1.0, 1));
    }

    @Test
    public void testIsValidShouldReturnFalseForEmptyName() {
        assertFalse(ItemValidator.isValid("   ", 2.5, 1));
    }

    @Test
    public void testIsValidShouldReturnFalseForZeroQuantity() {
        assertFalse(ItemValidator.isValid("Молоко", 2.5, 0));
    }

    @Test
    public void testIsValidShouldReturnFalseForNullName() {
        assertFalse(ItemValidator.isValid(null, 2.5, 1));
    }
}
