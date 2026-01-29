package entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import exception.NegativeTopUpException;
import java.util.List;

import static org.testng.Assert.*;
public class SubscriberTest {

    private Subscriber subscriber;

    @BeforeMethod
    public void setUp() {
        subscriber = new Subscriber("Иван Иванов", "375291112233", "A1", "Smart");
    }

    @Test
    public void testTopUpAccount_ValidAmount() {
        subscriber.topUpAccount(10.0);
    }

    @Test(expectedExceptions = NegativeTopUpException.class)
    public void testTopUpAccount_ZeroAmount() {
        Subscriber s = new Subscriber("Имя", "375291234567", "A1", "Smart");
        s.topUpAccount(0);
    }


    @Test
    public void testChangeTariffPlan_Valid() {
        subscriber.changeTariffPlan("Безлимит 30");
    }

    @Test
    public void testChangeTariffPlan_SameTariff() {
        subscriber.changeTariffPlan("Smart"); // тот же тариф, но система должна отработать
    }
    @Test
    public void testAddAndViewPayments() {
        Subscriber s = new Subscriber("Иван Иванов", "375291234567", "A1", "Smart");
        s.addPayment("Интернет", 10.0);
        s.addPayment("SMS", 2.5);

        List<Document> docs = s.getDocumentsByType("SMS");
        assertEquals(docs.size(), 1);
        assertEquals(docs.get(0).getType(), "SMS");
    }

    @Test
    public void testAddPaymentIgnoresNegative() {
        Subscriber s = new Subscriber("Тестовый", "375291234111", "МТС", "Промо");
        s.addPayment("Интернет", -5.0);

        List<Document> all = s.getDocumentsByType("Интернет");
        assertEquals(all.size(), 0);
    }

}
