package parse;

import entity.composite.TextComponent;
import entity.composite.TextComponentType;
import entity.composite.TextComposite;
import entity.composite.TextLeaf;
import exception.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordParser implements ParserHandler {
    private static final Logger logger = LoggerFactory.getLogger(WordParser.class);
    private static final String WORD_PUNCT_SPLIT_REGEX =
            "(?<=\\p{L})(?=\\p{Punct})|(?<=\\p{Punct})(?=\\p{L})|\\s+";

    private ParserHandler next;

    @Override
    public void setNext(ParserHandler next) {
        this.next = next;
    }

    @Override
    public TextComponent parse(String data) {
        if (data == null || data.isBlank()) {
            throw new ParserException("Невозможно распарсить пустую лексему");
        }

        logger.debug("Разделение лексемы на слова и знаки препинания...");
        TextComposite lexeme = new TextComposite(TextComponentType.LEXEME);
        String[] elements = data.strip().split(WORD_PUNCT_SPLIT_REGEX);

        for (String element : elements) {
            if (element.isBlank()) continue;
            TextComponentType type = isPunctuation(element)
                    ? TextComponentType.PUNCTUATION
                    : TextComponentType.WORD;
            lexeme.add(new TextLeaf(element, type));
        }

        return lexeme;
    }

    private boolean isPunctuation(String element) {
        return element.matches("\\p{Punct}+");
    }
}
