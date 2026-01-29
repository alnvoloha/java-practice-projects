package entity.composite;

import java.util.Collections;
import java.util.List;

public class TextLeaf implements TextComponent {
    private final String value;
    private final TextComponentType type;

    public TextLeaf(String value, TextComponentType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Leaf can't add children");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Leaf can't remove children");
    }

    @Override
    public List<TextComponent> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public String collect() {
        return value;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }
}
