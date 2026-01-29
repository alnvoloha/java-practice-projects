package customer;

import entity.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest {
    @Test
    public void testCustomerCreation() {
        Customer customer = new Customer(1L, "Ivanov", "Ivan", "Ivanovich", "Minsk, St. 1", "1234567812L", "12345678901234567890");
        Assert.assertEquals(customer.getId(), 1L);
        Assert.assertEquals(customer.getLastName(), "Ivanov");
        Assert.assertEquals(customer.getFirstName(), "Ivan");
        Assert.assertEquals(customer.getCreditCardNumber(), "1234567812");
    }

    @Test
    public void testCustomerClone() throws CloneNotSupportedException {
        Customer original = new Customer(2L, "Petrov", "Petr", "Petrovich", "Minsk, St. 2", "8765432187654321L", "09876543210987654321");
        Customer cloned = (Customer) original.clone();

        Assert.assertEquals(cloned.getId(), original.getId());
        Assert.assertEquals(cloned.getLastName(), original.getLastName());
        Assert.assertEquals(cloned.getCreditCardNumber(), original.getCreditCardNumber());
        Assert.assertNotSame(cloned, original);
    }
}
