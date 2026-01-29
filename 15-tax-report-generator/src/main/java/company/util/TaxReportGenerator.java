package company.util;

import company.entity.Tax;
import company.entity.TaxPayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class TaxReportGenerator {
    private static final Logger logger = LogManager.getLogger(TaxReportGenerator.class);

    public static void generateReport(List<TaxPayer> taxpayers) {
        logger.info("\n======= ОТЧЁТ О НАЛОГАХ =======");

        for (TaxPayer taxpayer : taxpayers) {
            logger.info("\nНалогоплательщик: {} {} (ИНН: {}, Возраст: {})",
                    taxpayer.getName(),
                    taxpayer.getSurname(),
                    taxpayer.getTaxId(),
                    taxpayer.getAge());

            double total = 0.0;
            List<Tax> sortedTaxes = taxpayer.getTaxes();
            sortedTaxes.sort(Comparator.comparingDouble(Tax::getAmount));

            logger.info("Налоги (отсортированы по сумме):");
            for (Tax tax : sortedTaxes) {
                logger.info("  - Сумма: {}", tax.getAmount());
                total += tax.getAmount();
            }
            logger.info("Общая сумма налога: {}", total);
        }

        logger.info("\n======= КОНЕЦ ОТЧЁТА =======");
    }
}