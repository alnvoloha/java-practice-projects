package company.util;

import company.entity.Income;

public class ValidationUtil {
    public static int validateAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr.trim());
            return (age > 0 && age < 120) ? age : 18; // Значение по умолчанию
        } catch (NumberFormatException e) {
            return 18; // Ошибка -> устанавливаем возраст 18
        }
    }

    public static String validateTaxId(String taxId) {
        return (taxId != null && taxId.matches("\\d{10}")) ? taxId : "0000000000"; // Должно быть 10 цифр
    }

    public static Income.IncomeType validateIncomeType(String typeStr) {
        try {
            return Income.IncomeType.valueOf(typeStr.trim()); // Проверяем, есть ли такой тип дохода
        } catch (IllegalArgumentException e) {
            return null; // Некорректный тип -> пропускаем
        }
    }

    public static double validateIncomeAmount(String amountStr) {
        try {
            double amount = Double.parseDouble(amountStr.trim());
            return (amount >= 0) ? amount : 0; // Доход не может быть отрицательным
        } catch (NumberFormatException e) {
            return 0; // Ошибка -> доход 0
        }
    }
}
