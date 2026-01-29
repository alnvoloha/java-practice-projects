package reader;

import exception.InvalidFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NumberReader {
    private static final Logger logger = LogManager.getLogger(NumberReader.class);
    private static final String INPUT_FILE = "src/main/resources/input.txt";

    public List<String> readAllNumbers() throws InvalidFileException {
        try {
            List<String> lines = Files.readAllLines(Path.of(INPUT_FILE));
            if (lines.isEmpty()) {
                throw new InvalidFileException("Файл пустой");
            }
            logger.info("Прочитано {} строк из файла", lines.size());
            return lines;
        } catch (IOException e) {
            throw new InvalidFileException("Ошибка чтения файла", e);
        }
    }
}
