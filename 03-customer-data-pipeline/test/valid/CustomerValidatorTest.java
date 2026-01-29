package valid;

import exceptions.InvalidCustomerDataException;
import valid.CustomerValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerValidatorTest {
    @Test
    public void testValidCreditCardNumber() throws InvalidCustomerDataException {
        CustomerValidator.validateCreditCardNumber("1234567812345678");
    }

    @Test(expectedExceptions = InvalidCustomerDataException.class)
    public void testInvalidCreditCardNumber() throws InvalidCustomerDataException {
        CustomerValidator.validateCreditCardNumber("12345L");
    }

    @Test
    public void testValidBankAccountNumber() throws InvalidCustomerDataException {
        CustomerValidator.validateBankAccountNumber("1234567890");
    }

    @Test(expectedExceptions = InvalidCustomerDataException.class)
    public void testInvalidBankAccountNumber() throws InvalidCustomerDataException {
        CustomerValidator.validateBankAccountNumber("12345");
    }

    @Test(expectedExceptions = InvalidCustomerDataException.class)
    public void testInvalidEmptyName() throws InvalidCustomerDataException {
        CustomerValidator.validateCustomerName("");
    }
}
