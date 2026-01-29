package entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InternetSubscriberImplTest {

    private InternetSubscriberImpl internetSub;

    @BeforeMethod
    public void setUp() {
        internetSub = new InternetSubscriberImpl("Ольга", "375296661100", "life:)", "Интернет 20GB");
    }

    @Test
    public void testRequestAdditionalDataPackage() {
        internetSub.requestAdditionalDataPackage(5);
    }

    @Test
    public void testSetStaticIP() {
        internetSub.setStaticIP("192.168.0.2");
    }
}
