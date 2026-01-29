package valid;

import exceptions.InvalidCustomerDataException;

public class CustomerValidator {
    public static void validateCreditCardNumber(String creditCardNumber) throws InvalidCustomerDataException {
        if (String.valueOf(creditCardNumber).length() != 16) {
            throw new InvalidCustomerDataException("Invalid credit card number. It must contain exactly 16 digits.");
        }
    }

    public static void validateBankAccountNumber(String bankAccountNumber) throws InvalidCustomerDataException {
        if (bankAccountNumber == null || bankAccountNumber.length() != 10) {
            throw new InvalidCustomerDataException("Invalid bank account number. It must contain exactly 20 characters.");
        }
    }

    public static void validateCustomerName(String name) throws InvalidCustomerDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidCustomerDataException("Invalid name. It cannot be empty.");
        }
    }
}
