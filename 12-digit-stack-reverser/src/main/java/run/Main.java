package run;

//2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.

import entity.DigitStack;
import exception.InvalidFileException;
import exception.InvalidNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reader.NumberReader;
import util.NumberReverser;
import valid.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        NumberReader reader = new NumberReader();
        NumberValidator validator = new NumberValidator();
        NumberReverser reverser = new NumberReverser();

        List<String> reversedNumbers = new ArrayList<>();

        try {
            List<String> lines = reader.readAllNumbers();
            for (String line : lines) {
                try {
                    String trimmed = line.trim();
                    validator.validate(trimmed);
                    DigitStack stack = reverser.toStack(trimmed);
                    String reversed = reverser.reverse(stack);
                    reversedNumbers.add(reversed);
                    logger.info("Успешная обработка строки: {}", trimmed);
                } catch (InvalidNumberException e) {
                    logger.warn("Строка пропущена: {} — {}", line, e.getMessage());
                }
            }
        } catch (InvalidFileException e) {
            logger.error("Ошибка чтения файла: {}", e.getMessage());
            System.out.println("Фатальная ошибка: " + e.getMessage());
            return;
        }

        System.out.println("Обратные числа:");
        for (String s : reversedNumbers) {
            System.out.println(s);
        }
    }
}
