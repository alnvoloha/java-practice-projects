/*  вариант:
        2.A В тексте каждую букву заменить ее порядковым номером в алфавите. При выводе в одной строке печатать текст с двумя пробелами между буквами, в следующей строке внизу под каждой буквой печатать ее номер.

        2.C Текст из n² символов шифруется по следующему правилу:

        — все символы текста записываются в квадратную таблицу размерности n в порядке слева направо, сверху вниз;

        — таблица поворачивается на 90° по часовой стрелке;

        — 1-я строка таблицы меняется местами с последней, 2-я — с предпоследней и т.д.;

        — 1-й столбец таблицы меняется местами со 2-м, 3-й — с 4-м и т.д.;

        — зашифрованный текст получается в результате обхода результирующей таблицы по спирали по часовой стрелке, начиная с левого верхнего угла.

       Зашифровать текст по указанному правилу.

*/

        package run;
import exception.InvalidTextException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import task.LetterNumberFormatter;
import task.SpiralEncryptor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        List<String> lines = readLinesFromResources("text.txt");
        if (lines == null || lines.isEmpty()) {
            logger.error("Файл text.txt пуст или не найден.");
            return;
        }

        logger.info("========== ЗАДАЧА 2.1 ==========");
        runLetterNumberTask(lines);

        logger.info("========== ЗАДАЧА 2.2 ==========");
        runSpiralEncryptionTask(lines);
    }

    private static void runLetterNumberTask(List<String> lines) {
        logger.info("--- Способ 1: методы класса String ---");
        lines.forEach(line -> {
            try {
                String result = LetterNumberFormatter.formatWithStringMethods(line);
                logger.info("\n{}", result);
            } catch (InvalidTextException e) {
                logger.warn("Пропущена строка (String Methods): \"{}\" — {}", line, e.getMessage());
            }
        });

        logger.info("--- Способ 2: Stream API ---");
        lines.forEach(line -> {
            try {
                String result = LetterNumberFormatter.formatWithStreams(line);
                logger.info("\n{}", result);
            } catch (InvalidTextException e) {
                logger.warn("Пропущена строка (Stream API): \"{}\" — {}", line, e.getMessage());
            }
        });
    }

    private static void runSpiralEncryptionTask(List<String> lines) {
        logger.info("--- Способ 1: методы класса String ---");
        lines.forEach(line -> {
            try {
                String result = SpiralEncryptor.encryptWithStringMethods(line);
                logger.info(result);
            } catch (InvalidTextException e) {
                logger.warn("Пропущена строка (String Methods): \"{}\" — {}", line, e.getMessage());
            }
        });

        logger.info("--- Способ 2: Stream API ---");
        lines.forEach(line -> {
            try {
                String result = SpiralEncryptor.encryptWithStreams(line);
                logger.info(result);
            } catch (InvalidTextException e) {
                logger.warn("Пропущена строка (Stream API): \"{}\" — {}", line, e.getMessage());
            }
        });
    }

    private static List<String> readLinesFromResources(String filename) {
        try {
            Path path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            return Files.readAllLines(path);
        } catch (IOException | URISyntaxException | NullPointerException e) {
            logger.error("Ошибка при чтении файла '{}': {}", filename, e.getMessage());
            return null;
        }
    }
}
