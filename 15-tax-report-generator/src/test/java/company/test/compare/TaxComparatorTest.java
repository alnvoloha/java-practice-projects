package company.test.compare;

import company.compare.TaxComparator;
import company.entity.Income;
import company.entity.Tax;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaxComparatorTest {
    @Test
    public void testTaxSorting() {
        List<Tax> taxes = Arrays.asList(
                new Tax(5000, "Налог 1", new Income(Income.IncomeType.MAIN_JOB, 50000, false)),
                new Tax(7000, "Налог 2", new Income(Income.IncomeType.SECOND_JOB, 70000, false)),
                new Tax(2000, "Налог 3", new Income(Income.IncomeType.GIFT, 10000, false))
        );

        taxes.sort(new TaxComparator());

        Assert.assertEquals(taxes.get(0).getAmount(), 7000.0, "Первый должен быть самый большой налог.");
        Assert.assertEquals(taxes.get(2).getAmount(), 2000.0, "Последний должен быть самый маленький налог.");
    }
}
