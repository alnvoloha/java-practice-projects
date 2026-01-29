package parse;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parse.LexemeParser;
import parse.SentenceParser;

import static org.testng.Assert.*;

public class SentenceParserTest {
    private SentenceParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        WordParser wordParser = new WordParser();
        lexemeParser.setNext(wordParser);
        parser.setNext(lexemeParser);
    }

    @Test
    public void testParseValidTextWithThreeSentences() {
        String input = "Hello world! This is a test. Another one?";
        TextComponent paragraph = parser.parse(input);

        assertEquals(paragraph.getChildren().size(), 3); // 3 предложения
    }

    @Test
    public void testParseEmptyStringReturnsEmpty() {
        String input = "";
        TextComponent paragraph = parser.parse(input);

        assertTrue(paragraph.getChildren().isEmpty());
    }
}
