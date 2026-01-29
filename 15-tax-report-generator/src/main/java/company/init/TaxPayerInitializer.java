package company.init;

import company.entity.TaxPayer;
import company.parse.TaxPayerParser;
import company.parse.IncomeParser;
import company.read.FileReaderUtil;
import company.util.TaxReportGenerator;
import company.exception.TaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaxPayerInitializer {
    public static List<TaxPayer> initialize(String filePath) {
        List<TaxPayer> taxpayers = new ArrayList<>();

        try {
            List<String> lines = FileReaderUtil.readLines(filePath);

            for (String line : lines) {
                try {
                    TaxPayer taxpayer = TaxPayerParser.parse(line);
                    taxpayer.getIncomes().addAll(IncomeParser.parseIncomes(line));
                    taxpayer.calculateTaxes();
                    taxpayers.add(taxpayer);
                } catch (TaxException e) {
                    System.err.println("Ошибка парсинга налогоплательщика: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        // Генерируем отчет
        TaxReportGenerator.generateReport(taxpayers);

        return taxpayers;
    }
}
