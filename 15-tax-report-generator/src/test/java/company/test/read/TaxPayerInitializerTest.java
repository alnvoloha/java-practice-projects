package company.test.read;

import company.entity.TaxPayer;
import company.init.TaxPayerInitializer;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TaxPayerInitializerTest {

    @Test
    public void testInitializeReadsDataCorrectly() {
        String testPath = "src/test/resources/test_input.txt";
        List<TaxPayer> list = TaxPayerInitializer.initialize(testPath);

        assertFalse(list.isEmpty());
        TaxPayer tp = list.get(0);

        assertEquals(tp.getName(), "Иван");
        assertEquals(tp.getSurname(), "Иванов");
        assertEquals(tp.getTaxId(), "1234567890");
        assertEquals(tp.getAge(), 35);
    }

    @Test
    public void testInitializeHandlesMissingFile() {
        String wrongPath = "src/test/resources/missing_file.txt";
        List<TaxPayer> list = TaxPayerInitializer.initialize(wrongPath);
        assertTrue(list.isEmpty());
    }
}
