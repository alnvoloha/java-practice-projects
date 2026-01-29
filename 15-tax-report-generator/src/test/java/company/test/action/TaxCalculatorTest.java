package company.test.action;

import company.entity.Income;
import company.entity.Tax;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class TaxCalculatorTest {

    @Test
    public void testCalculateTaxForSalary() {
        List<Income> incomes = new ArrayList<>();
        incomes.add(new Income(Income.IncomeType.SALARY, 10000, true));

        List<Tax> taxes = TaxCalculator.calculateTaxes(incomes);
        assertEquals(taxes.size(), 1);
        assertEquals(taxes.get(0).getAmount(), 1300.0, 0.01);
    }

    @Test
    public void testCalculateTaxForMultipleIncomes() {
        List<Income> incomes = new ArrayList<>();
        incomes.add(new Income(Income.IncomeType.SALARY, 10000, true));
        incomes.add(new Income(Income.IncomeType.GIFT, 5000, false));

        List<Tax> taxes = TaxCalculator.calculateTaxes(incomes);
        assertEquals(taxes.size(), 2);
        assertEquals(taxes.get(1).getAmount(), 500.0, 0.01);
    }
}