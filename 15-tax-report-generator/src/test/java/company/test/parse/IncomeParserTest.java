package company.test.parse;

import company.entity.Income;
import company.parse.IncomeParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class IncomeParserTest {
    @Test
    public void testParseIncomes() {
        // ВАЖНО: Строка должна начинаться с имени, фамилии, возраста, ИНН, потом доходы
        String line = "Иван;Петров;35;1234567890;MAIN_JOB;50000;SECOND_JOB;20000";
        List<Income> incomes = IncomeParser.parseIncomes(line);

        Assert.assertEquals(incomes.size(), 2, "Должно быть 2 дохода.");
        Assert.assertEquals(incomes.get(0).getType(), Income.IncomeType.MAIN_JOB);
        Assert.assertEquals(incomes.get(1).getAmount(), 20000.0);
    }
}
