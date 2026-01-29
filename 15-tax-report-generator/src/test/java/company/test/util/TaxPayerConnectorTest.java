package company.test.util;

import company.entity.Income;
import company.entity.TaxPayer;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class TaxPayerConnectorTest {

    @Test
    public void testSerializeCreatesFile() {
        List<TaxPayer> list = new ArrayList<>();
        TaxPayer tp = new TaxPayer("Ivan", "Ivanov", 35, "1234567890");
        tp.addIncome(new Income(Income.IncomeType.SALARY, 10000, true));
        list.add(tp);

        TaxPayerConnector.serialize(list, "src/test/resources/test_taxpayers.ser");
        File file = new File("src/test/resources/test_taxpayers.ser");

        assertTrue(file.exists() && file.length() > 0);
    }

    @Test
    public void testDeserializeReturnsCorrectData() {
        List<TaxPayer> list = TaxPayerConnector.deserialize("src/test/resources/test_taxpayers.ser");
        assertFalse(list.isEmpty());
        assertEquals(list.get(0).getName(), "Ivan");
    }
}
