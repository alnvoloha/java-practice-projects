package valid;

import exception.InvalidNumberException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberValidatorTest {

    private final NumberValidator validator = new NumberValidator();

    @Test
    public void testValidate_ValidNumber() throws InvalidNumberException {
        validator.validate("1234567890");
    }

    @Test(expectedExceptions = InvalidNumberException.class)
    public void testValidate_InvalidCharacters() throws InvalidNumberException {
        validator.validate("12a45");
    }

    @Test(expectedExceptions = InvalidNumberException.class)
    public void testValidate_EmptyString() throws InvalidNumberException {
        validator.validate("");
    }

    @Test(expectedExceptions = InvalidNumberException.class)
    public void testValidate_TooBigNumber() throws InvalidNumberException {
        validator.validate("99999999999999999999999999999999999999999999");
    }
}
