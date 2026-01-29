package parse;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;
import entity.composite.TextComposite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import exception.ParserException;

public class SentenceParser implements ParserHandler {
    private static final Logger logger = LoggerFactory.getLogger(SentenceParser.class);
    private static final String SENTENCE_REGEX = "(?<=[.!?])\\s+";

    private ParserHandler next;

    @Override
    public void setNext(ParserHandler next) {
        this.next = next;
    }

    @Override
    public TextComponent parse(String data) {
        logger.debug("Разделение на предложения...");
        TextComposite paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = data.split(SENTENCE_REGEX);

        for (String sentence : sentences) {
            if (sentence.isBlank()) continue;
            TextComposite sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
            if (next != null) {
                try {
                    TextComponent parsed = next.parse(sentence.strip());
                    for (TextComponent child : parsed.getChildren()) {
                        sentenceComponent.add(child);
                    }
                } catch (ParserException e) {
                    logger.warn("Ошибка при разборе предложения: '{}'", sentence.strip(), e);
                    continue;
                }
            }
            paragraphComponent.add(sentenceComponent);
        }

        logger.debug("Предложений найдено: {}", paragraphComponent.getChildren().size());
        return paragraphComponent;
    }
}
