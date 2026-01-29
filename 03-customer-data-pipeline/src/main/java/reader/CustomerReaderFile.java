package reader;

import entity.Customer;
import exceptions.InvalidCustomerDataException;
import valid.CustomerValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class CustomerReaderFile {

    public static List<Customer> readCustomersFromFile(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {

                    String[] data = line.split("\\s+");
                    if (data.length < 7) {
                        // Если полей меньше ожидаемого, тоже пропускаем
                        System.out.println("Skipping line due to not enough fields: " + line);
                        continue;
                    }

                    long id = Long.parseLong(data[0]);
                    String lastName = data[1].trim();
                    String firstName = data[2].trim();
                    String patronymic = data[3].trim();
                    String address = data[4].trim();
                    String creditCardNumber = data[5].trim();
                    String bankAccountNumber = data[6].trim();


                    CustomerValidator.validateCustomerName(lastName);
                    CustomerValidator.validateCustomerName(firstName);
                    CustomerValidator.validateCreditCardNumber(creditCardNumber);
                    CustomerValidator.validateBankAccountNumber(bankAccountNumber);


                    Customer customer = new Customer(
                            id, lastName, firstName, patronymic, address, creditCardNumber, bankAccountNumber
                    );
                    customers.add(customer);

                } catch (InvalidCustomerDataException | NumberFormatException e) {
                    // Если что-то не так, выводим в консоль и пропускаем
                    System.out.println("Skipping invalid data line: " + line);
                    System.out.println("Reason: " + e.getMessage());
                }
            }
        }
        return customers;
    }
}
