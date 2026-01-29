package company.parse;

import company.entity.Income;
import company.util.ValidationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class IncomeParser {
    private static final Logger logger = LogManager.getLogger(IncomeParser.class);

    public static List<Income> parseIncomes(String line) {
        List<Income> incomes = new ArrayList<>();
        String[] parts = line.split(";");
        if (parts.length < 5) return incomes;

        for (int i = 4; i < parts.length; i += 2) {
            Income.IncomeType type = ValidationUtil.validateIncomeType(parts[i].trim());
            double amount = ValidationUtil.validateIncomeAmount(parts[i + 1].trim());

            if (type != null) {
                incomes.add(new Income(type, amount, false));
                logger.info("Добавлен доход: {} - {}", type, amount);
            } else {
                logger.error("Ошибка: некорректный тип дохода в строке: {}", line);
            }
        }

        return incomes;
    }
}
