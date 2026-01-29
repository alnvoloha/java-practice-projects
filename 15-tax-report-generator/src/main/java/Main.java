/**
 * Вариант задания: "Налоги".
 * Определить множество и сумму налоговых выплат физического лица за год
 * с учетом доходов с основного и дополнительного мест работы, авторских вознаграждений,
 * продажи имущества, получения в подарок денежных сумм и имущества, переводов из-за границы,
 * льгот на детей и материальной помощи.
 * Провести сортировку налогов по сумме.
 */

import company.entity.Tax;
import company.entity.TaxPayer;
import company.init.TaxPayerInitializer;
import company.util.TaxPayerConnector;
import company.util.TaxReportGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        clearLogs();
        System.out.println(" Запуск программы...");

        String filePath = "src/main/resources/data.txt";

        // Загружаем налогоплательщиков из файла
        List<TaxPayer> taxpayers = TaxPayerInitializer.initialize(filePath);

        // Сохраняем сериализованные данные
        TaxPayerConnector.serialize(taxpayers, TaxPayerConnector.DEFAULT_PATH);

        // Читаем сериализованные данные
        List<TaxPayer> restored = TaxPayerConnector.deserialize(TaxPayerConnector.DEFAULT_PATH);

        // Сортировка налогов внутри каждого налогоплательщика по сумме
        for (TaxPayer tp : restored) {
            tp.getTaxes().sort(Comparator.comparingDouble(Tax::getAmount));
        }

        // Генерируем отчет на основе восстановленных и отсортированных данных
        TaxReportGenerator.generateReport(restored);

        System.out.println("Программа завершена.");
    }

    private static void clearLogs() {
        String[] logFiles = { "logs/report.log", "logs/errors.log", "logs/current.log" };
        for (String logFile : logFiles) {
            File file = new File(logFile);
            if (file.exists()) {
                try {
                    Files.write(file.toPath(), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException e) {
                    System.err.println("⚠️ Ошибка очистки файла: " + logFile);
                }
            }
        }
    }
}