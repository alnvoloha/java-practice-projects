package run;

import entity.Customer;
import exceptions.InvalidCustomerDataException;
import handler.CustomerHandler;
import reader.CustomerReaderConsole;
import reader.CustomerReaderFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose input method: 1 - Console, 2 - File");
        int choice = scanner.nextInt();
        scanner.nextLine();

        List<Customer> customers = null;

        try {
            if (choice == 1) {
                customers = CustomerReaderConsole.readMultipleCustomersFromConsole();
            } else if (choice == 2) {
                System.out.print("Enter file path (relative to resources): ");
                String relativeFilePath = "customers.txt";


                ClassLoader classLoader = Main.class.getClassLoader();

                if (classLoader.getResource(relativeFilePath) == null) {
                    System.out.println("Resource not found: " + relativeFilePath);
                    return;
                }

                String absolutePath = classLoader.getResource(relativeFilePath).getPath();
                customers = CustomerReaderFile.readCustomersFromFile(absolutePath);
            } else {
                System.out.println("Invalid choice. Exiting...");
                return;
            }

            if (customers == null || customers.isEmpty()) {
                System.out.println("No valid customers found.");
                return;
            }

            // a) Список покупателей в алфавитном порядке
            System.out.println("Customers sorted by last name:");
            List<Customer> sortedCustomers = CustomerHandler.sortCustomersByLastName(customers);
            sortedCustomers.forEach(System.out::println);


            System.out.println("Customers sorted by last name with Stream API:");
            List<Customer> sortedCustomersStreamAPI = CustomerHandler.sortCustomersByLastNameStreamAPI(customers);
            sortedCustomersStreamAPI.forEach(System.out::println);


            // b) Список покупателей, у которых номер кредитной карточки в заданном интервале
            System.out.println("\nEnter the range for credit card numbers:");
            System.out.print("Min: ");
            String min = scanner.nextLine();
            System.out.print("Max: ");
            String max = scanner.nextLine();

            // filterByCardNumber принимает массив, поэтому:
            Customer[] customerArray = customers.toArray(new Customer[0]);
            Optional<List<Customer>> filteredOpt = CustomerHandler.filterByCardNumber(customerArray, min, max);



            if (filteredOpt.isPresent()) {
                System.out.println("Customers in the given card range:");
                filteredOpt.get().forEach(System.out::println);
            } else {
                System.out.println("No customers found in the given card range.");
            }

            Optional<List<Customer>> filteredStream = CustomerHandler.filterByCardNumberStreamAPI(sortedCustomersStreamAPI, min, max);

            if (filteredStream.isPresent()) {
                System.out.println("\nFiltered (Stream API):");
                filteredStream.get().forEach(System.out::println);
            } else {
                System.out.println("\nNo customers in range (Stream API).");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
