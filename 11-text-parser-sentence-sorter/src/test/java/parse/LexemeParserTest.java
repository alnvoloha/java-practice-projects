package parse;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parse.LexemeParser;
import parse.WordParser;

import static org.testng.Assert.*;

public class LexemeParserTest {
    private LexemeParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new LexemeParser();
        parser.setNext(new WordParser()); // последний в цепи
    }

    @Test
    public void testParseValidSentenceWithLexemes() {
        String input = "word1, word2, word3.";
        TextComponent sentence = parser.parse(input);
        assertEquals(sentence.getChildren().size(), 5); // word1 , word2 , word3 .
    }


    @Test
    public void testParseEmptySentenceReturnsEmpty() {
        String input = "   ";
        TextComponent sentence = parser.parse(input);

        assertTrue(sentence.getChildren().isEmpty());
    }
}
