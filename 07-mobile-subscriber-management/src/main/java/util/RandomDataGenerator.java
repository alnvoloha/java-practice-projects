package util;

import java.util.List;
import java.util.Random;
import java.util.List;

public class RandomDataGenerator {
    /**
     * Утилита для генерации случайных данных:
     * номера, IP, операторы, тарифы.
     * Используется для тестов и генерации абонентов.
     */

    private static final List<String> OPERATORS = List.of("A1", "МТС", "life:)");
    private static final List<String> TARIFFS = List.of("Smart", "Безлимит", "Интернет 20GB", "Корп 100");
    private static final Random random = new Random();

    public static String randomPhoneNumber() {
        return "375" + (100000000 + random.nextInt(900000000));
    }

    public static String randomOperator() {
        return OPERATORS.get(random.nextInt(OPERATORS.size()));
    }

    public static String randomTariff() {
        return TARIFFS.get(random.nextInt(TARIFFS.size()));
    }

    public static String randomIPv4() {
        return random.nextInt(256) + "." +
                random.nextInt(256) + "." +
                random.nextInt(256) + "." +
                random.nextInt(256);
    }
}
