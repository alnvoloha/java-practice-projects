package task;

import util.AlphabetUtils;
import exception.InvalidTextException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LetterNumberFormatter {

    private static final Pattern LETTER_PATTERN = Pattern.compile("[a-zA-Z]");

    public static String formatWithStringMethods(String text) {
        if (text == null || text.isBlank()) {
            throw new InvalidTextException("Текст не может быть пустым или null");
        }

        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                line1.append(c).append("  ");
                int index = AlphabetUtils.getAlphabetIndex(c);
                line2.append(index).append("  ");
            }
        }

        return line1.toString().stripTrailing() + "\n" + line2.toString().stripTrailing();
    }

    public static String formatWithStreams(String text) {
        if (text == null || text.isBlank()) {
            throw new InvalidTextException("Текст не может быть пустым или null");
        }

        Matcher matcher = LETTER_PATTERN.matcher(text);

        List<String> letters = matcher.results()
                .map(MatchResult::group)
                .collect(Collectors.toList());

        String upperLine = String.join("  ", letters);
        String lowerLine = letters.stream()
                .map(s -> String.valueOf(AlphabetUtils.getAlphabetIndex(s.charAt(0))))
                .collect(Collectors.joining("  "));

        return upperLine + "\n" + lowerLine;
    }
}
