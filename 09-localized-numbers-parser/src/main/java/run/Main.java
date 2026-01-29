package run;

import entity.LocalizedNumberEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reader.LocalizedNumberReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String filePath = "src/main/resources/numbers.txt";

        List<LocalizedNumberEntry> entries;
        try {
            entries = new LocalizedNumberReader().read(filePath);
        } catch (IOException e) {
            logger.error("Ошибка чтения файла: {}", e.getMessage());
            return;
        } catch (OutOfMemoryError e) {
            logger.error("Ошибка: нехватка памяти при чтении файла!");
            return;
        }

        logger.info("Успешно прочитано {} корректных записей.", entries.size());
        entries.forEach(entry -> logger.info("{}", entry));

        if (!entries.isEmpty()) {
            BigDecimal sum = entries.stream()
                    .map(LocalizedNumberEntry::getValue)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal avg = sum.divide(BigDecimal.valueOf(entries.size()), BigDecimal.ROUND_HALF_UP);

            logger.info("Сумма: {}", sum.toPlainString());
            logger.info("Среднее: {}", avg.toPlainString());
        } else {
            logger.warn("Нет корректных записей для вычислений.");
        }
    }
}
