package reader;

import exception.TextReadException;
import util.TextUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileReader {
    public String read(String filePath) {
        try {
            String rawText = Files.readString(Path.of(filePath));
            return TextUtils.normalize(rawText);
        } catch (IOException e) {
            throw new TextReadException("Ошибка при чтении файла: " + filePath, e);
        }
    }
}
