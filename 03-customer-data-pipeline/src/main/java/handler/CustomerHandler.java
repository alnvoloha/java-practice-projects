package handler;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerHandler {
    public static List<Customer> sortCustomersByLastName(List<Customer> customers) {
        customers.sort((c1, c2) -> c1.getLastName().compareToIgnoreCase(c2.getLastName()));
        return customers;
    }

    public static List<Customer> sortCustomersByLastNameStreamAPI(List<Customer> customers) {

        return customers.stream()
                .sorted((c1, c2) -> c1.getLastName().compareToIgnoreCase(c2.getLastName()))
                .toList();
    }



    public static Optional<List<Customer>> filterByCardNumber(Customer[] customers, String min, String max) {
        List<Customer> filtered = new ArrayList<>();
        for (Customer c : customers) {
            if (c.getCreditCardNumber().compareTo(min) >= 0 && c.getCreditCardNumber().compareTo(max) <= 0) {
                filtered.add(c);
            }
        }
        return filtered.isEmpty() ? Optional.empty() : Optional.of(filtered);
    }

    public static Optional<List<Customer>> filterByCardNumberStreamAPI(List<Customer> customers, String min, String max) {
        List<Customer> filtered = customers.stream()
                .filter(c -> c.getCreditCardNumber().compareTo(min) >= 0
                        && c.getCreditCardNumber().compareTo(max) <= 0)
                .toList();

        return filtered.isEmpty() ? Optional.empty() : Optional.of(filtered);
    }

}
