package parse;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;
import entity.composite.TextComposite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import exception.ParserException;

public class ParagraphParser implements ParserHandler {
    private static final Logger logger = LoggerFactory.getLogger(ParagraphParser.class);
    private static final String PARAGRAPH_SPLIT_REGEX = "\\t+";

    private ParserHandler next;

    @Override
    public void setNext(ParserHandler next) {
        this.next = next;
    }

    @Override
    public TextComponent parse(String data) {
        logger.debug("Разделение на абзацы...");
        TextComposite text = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = data.split(PARAGRAPH_SPLIT_REGEX);

        for (String paragraph : paragraphs) {
            if (paragraph.isBlank()) continue;
            TextComponent paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
            if (next != null) {
                try {
                    TextComponent parsed = next.parse(paragraph.strip());
                    for (TextComponent child : parsed.getChildren()) {
                        paragraphComponent.add(child);
                    }
                } catch (ParserException e) {
                    logger.warn("Ошибка при разборе абзаца: '{}'", paragraph.strip(), e);
                    continue;
                }
            }
            text.add(paragraphComponent);
        }

        logger.debug("Абзацев найдено: {}", text.getChildren().size());
        return text;
    }
}
