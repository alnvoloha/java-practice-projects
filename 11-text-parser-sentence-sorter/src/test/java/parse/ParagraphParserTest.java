package test.parse;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import parse.ParagraphParser;
import parse.SentenceParser;

import static org.testng.Assert.*;

public class ParagraphParserTest {
    private ParagraphParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new ParagraphParser();
        parser.setNext(new SentenceParser()); // для простоты цепочку не углубляем
    }

    @Test
    public void testParseValidTextWithTwoParagraphs() {
        String input = "\tFirst sentence. Second sentence.\tAnother paragraph.";
        TextComponent component = parser.parse(input);

        assertEquals(component.getChildren().size(), 2); // два абзаца
    }

    @Test
    public void testParseEmptyStringReturnsEmpty() {
        String input = "\t\t";
        TextComponent component = parser.parse(input);

        assertTrue(component.getChildren().isEmpty());
    }
}
