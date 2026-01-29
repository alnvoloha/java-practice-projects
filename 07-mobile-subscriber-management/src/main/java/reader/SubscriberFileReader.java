package reader;

import entity.Subscriber;
import exception.InvalidOperatorException;
import exception.InvalidTariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberFileReader {

    private static final Logger logger = LogManager.getLogger(SubscriberFileReader.class);
    private static final List<String> allowedOperators = List.of("A1", "МТС", "life:)");

    public List<Subscriber> readFromReader(BufferedReader reader) throws IOException {
        List<Subscriber> subscribers = new ArrayList<>();
        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;
            try {
                String[] parts = line.split(";");
                if (parts.length != 4)
                    throw new IllegalArgumentException("Ожидалось 4 поля: имя;номер;оператор;тариф");

                String fullName = parts[0].trim();
                String phone = parts[1].trim();
                String operator = parts[2].trim();
                String tariff = parts[3].trim();

                if (fullName.isBlank() || phone.isBlank())
                    throw new IllegalArgumentException("Имя или номер пустые");

                if (!allowedOperators.contains(operator))
                    throw new InvalidOperatorException("Оператор \"" + operator + "\" не поддерживается");

                if (tariff.isBlank())
                    throw new InvalidTariffException();

                subscribers.add(new Subscriber(fullName, phone, operator, tariff));

            } catch (Exception e) {
                logger.warn("Ошибка на строке " + lineNumber + ": " + e.getMessage());
            }
        }
        return subscribers;
    }
}
