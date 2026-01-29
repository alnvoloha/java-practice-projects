
// Ошибку исправила, изменения произошли в PaymentReader.
// Было: throw new InvalidItemException("Ошибка в строке " + lineNumber + ": " + e.getMessage(), e);
// Стало:  logger.warn("Строка №{} пропущена из-за ошибки: {}\n→ Содержание: {}", lineNumber, e.getMessage(), line);



package run;

import entity.Payment;
import exception.InvalidItemException;
import reader.PaymentReader;
import unit.PaymentCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String filePath = "src/main/resources/data.txt"; // путь до файла с покупками

        try {
            Payment payment = PaymentReader.readFromFile(filePath);

            logger.info("Список товаров:");
            for (Payment.Item item : payment.getItems()) {
                logger.info(" - {}", item);
            //неявный вызов метода toString()
            }

            double totalAmount = PaymentCalculator.calculateTotalAmount(payment);
            int totalQuantity = PaymentCalculator.calculateTotalQuantity(payment);

            logger.info("Итоговая сумма: {}", totalAmount);
            logger.info("Общее количество товаров: {}", totalQuantity);

        } catch (IOException e) {
            logger.error("Ошибка чтения файла: {}", e.getMessage());
        }
    }
}
