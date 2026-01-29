package entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CorporateSubscriberImplTest {

    private CorporateSubscriberImpl corpSub;

    @BeforeMethod
    public void setUp() {
        corpSub = new CorporateSubscriberImpl("ООО Бизнес", "375331112233", "МТС", "Корпоративный 100");
    }

    @Test
    public void testAddEmployeeNumber() {
        corpSub.addEmployeeNumber("375291234567");
    }

    @Test
    public void testGenerateCorporateInvoice() {
        corpSub.addEmployeeNumber("375291234567");
        corpSub.addEmployeeNumber("375291111111");
        corpSub.generateCorporateInvoice();
    }
}
