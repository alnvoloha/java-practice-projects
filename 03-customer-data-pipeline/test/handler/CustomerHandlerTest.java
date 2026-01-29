package handler;

import entity.Customer;
import handler.CustomerHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CustomerHandlerTest {
    @Test
    public void testSortCustomersByLastName() {
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "Petrov", "Petr", "Petrovich", "Address 1", "1111222233334444L", "12345678901234567890"),
                new Customer(2L, "Ivanov", "Ivan", "Ivanovich", "Address 2", "5555666677778888L", "09876543210987654321"),
                new Customer(3L, "Sidorov", "Sergey", "Sergeevich", "Address 3", "9999000011112222L", "11223344556677889900")
        );

        List<Customer> sortedCustomers = CustomerHandler.sortCustomersByLastName(customers);

        Assert.assertEquals(sortedCustomers.get(0).getLastName(), "Ivanov");
        Assert.assertEquals(sortedCustomers.get(1).getLastName(), "Petrov");
        Assert.assertEquals(sortedCustomers.get(2).getLastName(), "Sidorov");
    }
}
