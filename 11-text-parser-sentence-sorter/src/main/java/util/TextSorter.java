package util;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextSorter {
    public static List<String> sortSentencesByWordCount(TextComponent text) {
        List<TextComponent> sentences = new ArrayList<>();

        for (TextComponent paragraph : text.getChildren()) {
            if (paragraph.getType() != TextComponentType.PARAGRAPH) continue;
            for (TextComponent sentence : paragraph.getChildren()) {
                if (sentence.getType() == TextComponentType.SENTENCE) {
                    sentences.add(sentence);
                }
            }
        }

        sentences.sort(Comparator.comparingInt(TextSorter::countWords));

        List<String> result = new ArrayList<>();
        for (TextComponent sentence : sentences) {
            result.add(sentence.collect());
        }

        return result;
    }

    private static int countWords(TextComponent sentence) {
        int count = 0;
        for (TextComponent lexeme : sentence.getChildren()) {
            count += lexeme.getChildren().stream()
                    .filter(c -> c.getType() == TextComponentType.WORD)
                    .count();
        }
        return count;
    }
}
