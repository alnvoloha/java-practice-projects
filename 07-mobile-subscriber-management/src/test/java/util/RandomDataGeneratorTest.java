
package util;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class RandomDataGeneratorTest {

    @Test
    public void testRandomPhoneNumber() {
        String phone = RandomDataGenerator.randomPhoneNumber();
        assertTrue(phone.matches("375\\d{9}"));
    }

    @Test
    public void testRandomOperator() {
        String operator = RandomDataGenerator.randomOperator();
        assertTrue(List.of("A1", "МТС", "life:)").contains(operator));
    }

    @Test
    public void testRandomTariff() {
        String tariff = RandomDataGenerator.randomTariff();
        assertNotNull(tariff);
        assertFalse(tariff.isBlank());
    }

    @Test
    public void testRandomIPv4() {
        String ip = RandomDataGenerator.randomIPv4();
        assertTrue(ip.matches("\\d{1,3}(\\.\\d{1,3}){3}"));
    }
}