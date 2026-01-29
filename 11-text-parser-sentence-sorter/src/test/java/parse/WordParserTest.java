package parse;

import entity.composite.TextComponentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parse.WordParser;
import exception.ParserException;

public class WordParserTest {
    private WordParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new WordParser();
    }

    @Test(expectedExceptions = ParserException.class)
    public void testParseEmptyLexemeReturnsException() {
        String input = " ";
        parser.parse(input);
    }

    @Test
    public void testParseWordWithPunctuation() {
        String input = "Hello,";
        var result = parser.parse(input);
        assert result.getChildren().size() == 2; // слово и знак препинания
    }
}
