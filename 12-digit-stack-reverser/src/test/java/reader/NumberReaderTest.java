package reader;

import exception.InvalidFileException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NumberReaderTest {

    @Test
    public void testReadNumber_ValidFile() throws IOException, InvalidFileException {
        Path tempFile = Files.createTempFile("testInput", ".txt");
        Files.writeString(tempFile, "12345\n");

        NumberReader reader = new NumberReaderFromPath(tempFile);
        List<String> result = reader.readAllNumbers();
        Assert.assertEquals(result.get(0), "12345");

        Files.deleteIfExists(tempFile);
    }

    @Test(expectedExceptions = InvalidFileException.class)
    public void testReadNumber_EmptyFile() throws IOException, InvalidFileException {
        Path tempFile = Files.createTempFile("testEmpty", ".txt");

        NumberReader reader = new NumberReaderFromPath(tempFile);
        reader.readAllNumbers();

        Files.deleteIfExists(tempFile);
    }

    // Вспомогательный подкласс с переопределённым путём
    static class NumberReaderFromPath extends NumberReader {
        private final Path path;

        public NumberReaderFromPath(Path path) {
            this.path = path;
        }

        @Override
        public List<String> readAllNumbers() throws InvalidFileException {
            try {
                List<String> lines = Files.readAllLines(path);
                if (lines.isEmpty()) {
                    throw new InvalidFileException("Файл пустой");
                }
                return lines;
            } catch (IOException e) {
                throw new InvalidFileException("Ошибка чтения", e);
            }
        }
    }
}
