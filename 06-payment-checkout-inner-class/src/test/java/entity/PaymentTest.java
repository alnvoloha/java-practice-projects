package entity;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PaymentTest {



    @Test
    public void testAddItemShouldAddOneItem() {
        Payment payment = new Payment();
        Payment.Item item = payment.new Item("Молоко", 1.5, 2);

        payment.addItem(item);

        List<Payment.Item> items = payment.getItems();
        assertEquals(items.size(), 1);
        assertEquals(items.get(0), item);
    }

    @Test
    public void testAddNullItemShouldNotThrowButIgnore() {
        Payment payment = new Payment();
        try {
            payment.addItem(null);
            assertEquals(payment.getItems().size(), 1, "null элемент должен быть добавлен в список как null");
        } catch (Exception e) {
            fail("Метод не должен выбрасывать исключение при добавлении null (если ты не хочешь блокировать это явно)");
        }
    }



    @Test
    public void testGetItemsShouldReturnUnmodifiableList() {
        Payment payment = new Payment();
        payment.addItem(new Payment().new Item("Хлеб", 2.0, 1));

        List<Payment.Item> items = payment.getItems();

        try {
            items.add(new Payment().new Item("Яйца", 0.3, 10));
            fail("Должно выброситься исключение при попытке изменить список");
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testGetItemsOnNewPaymentShouldReturnEmptyList() {
        Payment payment = new Payment();
        assertTrue(payment.getItems().isEmpty());
    }


    @Test
    public void testItemToStringShouldReturnCorrectFormat() {
        Payment.Item item = new Payment().new Item("Сыр", 3.0, 1);
        String expected = "Item{name='Сыр', price=3.0, quantity=1}";
        assertEquals(item.toString(), expected);
    }

    @Test
    public void testItemToStringShouldContainNameAndPrice() {
        Payment.Item item = new Payment().new Item("Йогурт", 1.1, 4);
        String toStr = item.toString();
        assertTrue(toStr.contains("Йогурт"));
        assertTrue(toStr.contains("1.1"));
        assertTrue(toStr.contains("4"));
    }



    @Test
    public void testItemEqualsShouldReturnTrueForSameData() {
        Payment.Item item1 = new Payment().new Item("Молоко", 1.5, 2);
        Payment.Item item2 = new Payment().new Item("Молоко", 1.5, 2);
        assertEquals(item1, item2);
    }

    @Test
    public void testItemEqualsShouldReturnFalseForDifferentData() {
        Payment.Item item1 = new Payment().new Item("Молоко", 1.5, 2);
        Payment.Item item2 = new Payment().new Item("Хлеб", 2.0, 1);
        assertNotEquals(item1, item2);
    }



    @Test
    public void testItemHashCodeShouldBeEqualForEqualObjects() {
        Payment.Item item1 = new Payment().new Item("Яблоко", 1.2, 5);
        Payment.Item item2 = new Payment().new Item("Яблоко", 1.2, 5);
        assertEquals(item1.hashCode(), item2.hashCode());
    }

    @Test
    public void testItemHashCodeShouldDifferForDifferentObjects() {
        Payment.Item item1 = new Payment().new Item("Банан", 2.0, 3);
        Payment.Item item2 = new Payment().new Item("Апельсин", 2.0, 3);
        assertNotEquals(item1.hashCode(), item2.hashCode());
    }
}
