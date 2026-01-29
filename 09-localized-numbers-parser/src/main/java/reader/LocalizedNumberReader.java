package reader;
import java.util.Locale;

import entity.LocalizedNumberEntry;
import exception.InvalidNumberEntryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.NumberUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LocalizedNumberReader {
    private static final Logger logger = LoggerFactory.getLogger(LocalizedNumberReader.class);

    public List<LocalizedNumberEntry> read(String filePath) throws IOException {
        List<LocalizedNumberEntry> entries = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(filePath));

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).strip();
            if (line.isBlank()) continue;

            String[] parts = line.split("\\s+", 2);
            if (parts.length != 2) {
                logger.warn("Строка {} пропущена: неправильный формат '{}'", i + 1, line);
                continue;
            }

            String localeStr = parts[0];
            String numberStr = parts[1];

            try {
                BigDecimal value = NumberUtils.parseLocalizedNumber(localeStr, numberStr);
                entries.add(new LocalizedNumberEntry(Locale.forLanguageTag(localeStr.replace('_', '-')), value));
            } catch (InvalidNumberEntryException e) {
                logger.warn("Строка {} пропущена: {}", i + 1, e.getMessage());
            } catch (Exception e) {
                logger.error("Ошибка в строке {}: {}", i + 1, e.getMessage(), e);
            }
        }

        return entries;
    }
}
