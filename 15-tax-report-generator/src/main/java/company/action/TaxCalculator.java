package company.action;

import company.entity.Income;
import company.entity.Tax;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculator {
    public static List<Tax> calculateTaxes(List<Income> incomes) {
        List<Tax> taxes = new ArrayList<>();

        for (Income income : incomes) {
            double taxRate = getTaxRate(income);
            double taxAmount = income.getAmount() * taxRate;

            Tax tax = new Tax(taxAmount, "Налог на " + income.getType(), income);
            taxes.add(tax);
        }

        return taxes;
    }

    private static double getTaxRate(Income income) {
        switch (income.getType()) {
            case MAIN_JOB: return 0.13; // 13% подоходный налог
            case SECOND_JOB: return 0.15; // 15% на подработку
            case AUTHOR_REWARD: return 0.10; // 10% за авторские вознаграждения
            case PROPERTY_SALE: return 0.20; // 20% с продажи имущества
            case GIFT: return 0.05; // 5% налог на подарки
            case FOREIGN_TRANSFER: return 0.12; // 12% налог на заграничные переводы
            default: return 0.0;
        }
    }
}
