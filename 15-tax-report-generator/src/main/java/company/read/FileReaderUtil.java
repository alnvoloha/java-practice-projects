package company.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderUtil {
    public static List<String> readLines(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath));
    }
}
