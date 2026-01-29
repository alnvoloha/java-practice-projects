package entity.composite;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TextCompositeTest {

    @Test
    public void testAddAndGetChildren() {
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        TextLeaf leaf = new TextLeaf("Hello", TextComponentType.WORD);
        composite.add(leaf);
        List<TextComponent> children = composite.getChildren();
        assertEquals(children.size(), 1);
    }

    @Test
    public void testRemoveChild() {
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        TextLeaf leaf = new TextLeaf("Hello", TextComponentType.WORD);
        composite.add(leaf);
        composite.remove(leaf);
        assertTrue(composite.getChildren().isEmpty());
    }

    @Test
    public void testCollectSentence() {
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        composite.add(new TextLeaf("Hello", TextComponentType.WORD));
        composite.add(new TextLeaf("world", TextComponentType.WORD));
        assertEquals(composite.collect(), "Hello world");
    }

    @Test
    public void testCollectParagraphWithLineBreak() {
        TextComposite paragraph = new TextComposite(TextComponentType.PARAGRAPH);
        TextComposite sentence = new TextComposite(TextComponentType.SENTENCE);
        sentence.add(new TextLeaf("One", TextComponentType.WORD));
        paragraph.add(sentence);
        assertEquals(paragraph.collect(), "One");
    }

    @Test
    public void testGetTypeReturnsCorrectType() {
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        assertEquals(composite.getType(), TextComponentType.LEXEME);
    }
}
