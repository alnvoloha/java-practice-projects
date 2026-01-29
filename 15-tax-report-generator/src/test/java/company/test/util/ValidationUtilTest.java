package company.test.util;

import company.entity.Income;
import company.util.ValidationUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationUtilTest {

    @Test
    public void testValidateAge() {
        Assert.assertEquals(ValidationUtil.validateAge("30"), 30, "Должен быть 30");
        Assert.assertEquals(ValidationUtil.validateAge("-5"), 18, "Отрицательный возраст должен быть 18");
        Assert.assertEquals(ValidationUtil.validateAge("150"), 18, "Возраст >120 должен быть 18");
        Assert.assertEquals(ValidationUtil.validateAge("abc"), 18, "Некорректные данные должны возвращать 18");
    }

    @Test
    public void testValidateTaxId() {
        Assert.assertEquals(ValidationUtil.validateTaxId("1234567890"), "1234567890", "Корректный ИНН");
        Assert.assertEquals(ValidationUtil.validateTaxId("abc"), "0000000000", "Некорректный ИНН -> 0000000000");
        Assert.assertEquals(ValidationUtil.validateTaxId("12345"), "0000000000", "ИНН < 10 цифр -> 0000000000");
    }

    @Test
    public void testValidateIncomeType() {
        Assert.assertEquals(ValidationUtil.validateIncomeType("MAIN_JOB"), Income.IncomeType.MAIN_JOB, "Должен быть MAIN_JOB");
        Assert.assertNull(ValidationUtil.validateIncomeType("RANDOM_TYPE"), "Некорректный тип должен быть null");
        Assert.assertNull(ValidationUtil.validateIncomeType(""), "Пустая строка -> null");
    }

    @Test
    public void testValidateIncomeAmount() {
        Assert.assertEquals(ValidationUtil.validateIncomeAmount("50000"), 50000.0, "Корректное значение");
        Assert.assertEquals(ValidationUtil.validateIncomeAmount("-1000"), 0.0, "Отрицательная сумма -> 0");
        Assert.assertEquals(ValidationUtil.validateIncomeAmount("abc"), 0.0, "Некорректное значение -> 0");
    }
}
