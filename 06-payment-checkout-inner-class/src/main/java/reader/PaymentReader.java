package reader;

import entity.Payment;
import exception.InvalidItemException;
import parse.ItemParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PaymentReader {
    private static final Logger logger = LoggerFactory.getLogger(PaymentReader.class);

    /**
     * Читает файл построчно, парсит каждую строку в {@link entity.Payment.Item}
     * и добавляет их в объект Payment.
     * @param filePath путь к файлу с покупкой
     * @return объект Payment с товарами
     * @throws IOException если файл не найден или не читается
     * @throws InvalidItemException если хотя бы одна строка содержит некорректные данные
     */

    public static Payment readFromFile(String filePath) throws IOException {
        Payment payment = new Payment();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                try {
                    Payment.Item item = ItemParser.parse(line, payment);
                    payment.addItem(item);
                } catch (InvalidItemException e) {

                    logger.warn("Строка №{} пропущена из-за ошибки: {}\n→ Содержание: {}", lineNumber, e.getMessage(), line);
                }
                lineNumber++;
            }
        }

        return payment;
    }
}
