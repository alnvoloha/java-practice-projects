package valid;

import exception.InvalidNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidator implements Validator<String> {
    private static final Logger logger = LogManager.getLogger(NumberValidator.class);

    @Override
    public void validate(String input) throws InvalidNumberException {
        if (input == null || input.isBlank()) {
            logger.error("Пустая строка");
            throw new InvalidNumberException("Пустая строка");
        }

        if (!input.matches("\\d+")) {
            logger.error("Невалидный формат числа: {}", input);
            throw new InvalidNumberException("Число должно содержать только цифры");
        }

        try {
            Long.parseLong(input); // или BigInteger
        } catch (NumberFormatException e) {
            logger.error("Слишком большое число: {}", input);
            throw new InvalidNumberException("Число выходит за допустимые границы", e);
        }

        logger.info("Проверка пройдена: {}", input);
    }
}
