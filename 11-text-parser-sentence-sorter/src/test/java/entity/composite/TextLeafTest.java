package entity.composite;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextLeafTest {

    @Test
    public void testCollectReturnsCorrectValue() {
        TextLeaf leaf = new TextLeaf("Hello", TextComponentType.WORD);
        assertEquals(leaf.collect(), "Hello");
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAddThrowsException() {
        TextLeaf leaf = new TextLeaf("word", TextComponentType.WORD);
        leaf.add(new TextLeaf("test", TextComponentType.WORD)); // должно выбросить исключение
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testRemoveThrowsException() {
        TextLeaf leaf = new TextLeaf("word", TextComponentType.WORD);
        leaf.remove(new TextLeaf("test", TextComponentType.WORD)); // должно выбросить исключение
    }

    @Test
    public void testGetTypeReturnsCorrectType() {
        TextLeaf leaf = new TextLeaf(",", TextComponentType.PUNCTUATION);
        assertEquals(leaf.getType(), TextComponentType.PUNCTUATION);
    }

    @Test
    public void testGetChildrenReturnsEmptyList() {
        TextLeaf leaf = new TextLeaf("!", TextComponentType.PUNCTUATION);
        assertTrue(leaf.getChildren().isEmpty());
    }
}
