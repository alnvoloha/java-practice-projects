package entity.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextComposite implements TextComponent {
    private final List<TextComponent> components = new ArrayList<>();
    private final TextComponentType type;

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public List<TextComponent> getChildren() {
        return Collections.unmodifiableList(components);
    }

    @Override
    public String collect() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent component : components) {
            sb.append(component.collect());
            if (type == TextComponentType.PARAGRAPH) {
                sb.append("\n");
            } else if (type == TextComponentType.SENTENCE) {
                sb.append(" ");
            } else if (type == TextComponentType.WORD || type == TextComponentType.LEXEME) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    @Override
    public TextComponentType getType() {
        return type;
    }
}
