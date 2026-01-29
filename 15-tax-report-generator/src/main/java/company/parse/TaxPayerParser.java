package company.parse;

import company.create.TaxPayerFactory;
import company.entity.Person;
import company.entity.TaxPayer;
import company.exception.TaxException;
import company.util.ValidationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaxPayerParser {
    private static final Logger logger = LogManager.getLogger(TaxPayerParser.class);

    public static TaxPayer parse(String line) throws TaxException {
        String[] parts = line.split(";");

        if (parts.length < 4) {
            logger.error("Ошибка: недостаточно данных в строке -> {}", line);
            throw new TaxException("Ошибка: недостаточно данных в строке -> " + line);
        }

        String name = parts[0].trim();
        String surname = parts[1].trim();
        int age = ValidationUtil.validateAge(parts[2].trim());
        String taxId = ValidationUtil.validateTaxId(parts[3].trim());

        TaxPayer taxpayer = TaxPayerFactory.createTaxPayer(name, surname, age, taxId);
        logger.info("Создан налогоплательщик: {} {}, возраст {}, ИНН {}", name, surname, age, taxId);

        return taxpayer;
    }
}
