package util;

import entity.composite.*;
import org.testng.annotations.Test;
import util.TextSorter;

import java.util.List;

import static org.testng.Assert.*;

public class TextSorterTest {

    @Test
    public void testSortSentencesByWordCount_Valid() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);

        TextComposite paragraph = new TextComposite(TextComponentType.PARAGRAPH);

        TextComposite sentence1 = new TextComposite(TextComponentType.SENTENCE);
        sentence1.add(newLeafLexeme("Hello"));
        sentence1.add(newLeafLexeme("world"));

        TextComposite sentence2 = new TextComposite(TextComponentType.SENTENCE);
        sentence2.add(newLeafLexeme("Short"));

        paragraph.add(sentence1);
        paragraph.add(sentence2);
        text.add(paragraph);

        List<String> result = TextSorter.sortSentencesByWordCount(text);

        assertEquals(result.get(0), "Short");
    }

    @Test
    public void testSortSentencesByWordCount_Empty() {
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        List<String> result = TextSorter.sortSentencesByWordCount(text);
        assertTrue(result.isEmpty());
    }

    private TextComponent newLeafLexeme(String word) {
        TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);
        lexeme.add(new TextLeaf(word, TextComponentType.WORD));
        return lexeme;
    }
}
