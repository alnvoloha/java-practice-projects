package company.test.util;

import company.entity.Person;
import company.entity.TaxPayer;
import company.util.TaxReportGenerator;
import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class TaxReportGeneratorTest {

    @Test
    public void testGenerateReport() {
        List<TaxPayer> taxpayers = new ArrayList<>();
        taxpayers.add(new TaxPayer(new Person("Иван", "Петров", 35, "1234567890")));
        taxpayers.add(new TaxPayer(new Person("Анна", "Сидорова", 40, "0987654321")));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        TaxReportGenerator.generateReport(taxpayers);

        System.setOut(System.out);

        String reportOutput = outputStream.toString();
        assertTrue(reportOutput.contains("Иван Петров"), "Отчет должен содержать имя Иван Петров");
        assertTrue(reportOutput.contains("Анна Сидорова"), "Отчет должен содержать имя Анна Сидорова");
    }
}
