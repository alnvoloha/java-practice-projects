package reader;

import entity.Customer;
import exceptions.InvalidCustomerDataException;
import valid.CustomerValidator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerReaderConsole {
    public static Customer readCustomerFromConsole() throws InvalidCustomerDataException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        CustomerValidator.validateCustomerName(lastName);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        CustomerValidator.validateCustomerName(firstName);

        System.out.print("Enter patronymic: ");
        String patronymic = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter credit card number (16 digits): ");
        String creditCardNumber = scanner.next();
        CustomerValidator.validateCreditCardNumber(creditCardNumber);
        scanner.nextLine();

        scanner.nextLine();

        System.out.print("Enter bank account number (20 characters): ");
        String bankAccountNumber = scanner.nextLine();
        CustomerValidator.validateBankAccountNumber(bankAccountNumber);

        return new Customer(id, lastName, firstName, patronymic, address, creditCardNumber, bankAccountNumber);
    }
    public static List<Customer> readMultipleCustomersFromConsole() {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        System.out.print("Enter how many customers you want to input: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("=== Enter data for customer #" + (i + 1) + " ===");
                Customer customer = readCustomerFromConsole();

                customers.add(customer);
            } catch (InvalidCustomerDataException e) {

                System.out.println("Skipping invalid data for this customer. Reason: " + e.getMessage());

            }
        }
        return customers;
    }
}
