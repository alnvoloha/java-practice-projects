package parse;

import entity.composite.TextComponent;

public interface ParserHandler {
    void setNext(ParserHandler next);
    TextComponent parse(String data);
}
