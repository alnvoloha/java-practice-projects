package unit;

import entity.Payment;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PaymentCalculatorTest {

    @Test
    public void testCalculateTotalAmountShouldReturnCorrectSum() {
        Payment payment = new Payment();
        payment.addItem(payment.new Item("Молоко", 2.5, 2)); // 5.0
        payment.addItem(payment.new Item("Хлеб", 1.5, 1));   // 1.5

        double total = PaymentCalculator.calculateTotalAmount(payment);
        assertEquals(total, 6.5);
    }

    @Test
    public void testCalculateTotalAmountShouldReturnZeroForEmptyPayment() {
        Payment payment = new Payment();
        double total = PaymentCalculator.calculateTotalAmount(payment);
        assertEquals(total, 0.0);
    }

    @Test
    public void testCalculateTotalQuantityShouldReturnCorrectAmount() {
        Payment payment = new Payment();
        payment.addItem(payment.new Item("Сыр", 3.0, 2));
        payment.addItem(payment.new Item("Йогурт", 1.0, 3));

        int totalQuantity = PaymentCalculator.calculateTotalQuantity(payment);
        assertEquals(totalQuantity, 5);
    }

    @Test
    public void testCalculateTotalQuantityShouldReturnZeroForEmptyPayment() {
        Payment payment = new Payment();
        int totalQuantity = PaymentCalculator.calculateTotalQuantity(payment);
        assertEquals(totalQuantity, 0);
    }
}
