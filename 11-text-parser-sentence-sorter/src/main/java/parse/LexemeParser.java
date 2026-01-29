package parse;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;
import entity.composite.TextComposite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import exception.ParserException;

public class LexemeParser implements ParserHandler {
    private static final Logger logger = LoggerFactory.getLogger(LexemeParser.class);
    private static final String LEXEME_REGEX = "\\s*(?=,)|\\s+";

    private ParserHandler next;

    @Override
    public void setNext(ParserHandler next) {
        this.next = next;
    }

    @Override
    public TextComponent parse(String data) {
        logger.debug("Разделение на лексемы...");
        TextComposite sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = data.strip().split(LEXEME_REGEX);

        for (String lexeme : lexemes) {
            if (lexeme.isBlank()) continue;
            TextComponent lexemeComponent = new TextComposite(TextComponentType.LEXEME);
            if (next != null) {
                try {
                    TextComponent parsed = next.parse(lexeme);
                    for (TextComponent child : parsed.getChildren()) {
                        lexemeComponent.add(child);
                    }
                } catch (ParserException e) {
                    logger.warn("Ошибка при разборе лексемы: '{}'", lexeme, e);
                    continue;
                }
            }
            sentenceComponent.add(lexemeComponent);
        }

        logger.debug("Лексем найдено: {}", sentenceComponent.getChildren().size());
        return sentenceComponent;
    }
}
