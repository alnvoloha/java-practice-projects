
package util;

import entity.Subscriber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RandomSubscriberWriter {
    /**
     * Генератор случайных абонентов и запись их в файл.
     * Применяется для отладки и демонстрации.
     */

    private static final Logger logger = LogManager.getLogger(RandomSubscriberWriter.class);

    public static void writeRandomSubscribers(Path outputPath, int count) {
        List<Subscriber> generated = generateSubscribers(count);

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            for (Subscriber s : generated) {
                writer.write(s.getFullName() + ";" +
                        s.getPhoneNumber() + ";" +
                        s.getOperator() + ";" +
                        s.getTariffPlan());
                writer.newLine();
            }
            logger.info("Сгенерировано и записано " + count + " абонентов в файл: " + outputPath);
        } catch (IOException e) {
            logger.error("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private static List<Subscriber> generateSubscribers(int count) {
        List<Subscriber> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String name = "User_" + (i + 1);
            String phone = RandomDataGenerator.randomPhoneNumber();
            String operator = RandomDataGenerator.randomOperator();
            String tariff = RandomDataGenerator.randomTariff();
            list.add(new Subscriber(name, phone, operator, tariff));
        }
        return list;
    }
}