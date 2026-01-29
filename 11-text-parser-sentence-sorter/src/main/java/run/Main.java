/*Вариант задания -- 2. Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.

Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Абзац, Лексема, Знак препинания и др. Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом.

Предварительно текст следует разобрать на составные части, выполнить

одно из перечисленных ниже заданий и вывести полученный результат.
*/

//Для проверки всех тестов -- файл run-tests.bat

//Для проверки на вылет исключений
/*	This is a valid paragraph. It has correct sentences!



	 	!?!?!?!

	Another valid paragraph. Java is great.

	 .  ,  ;   :   ?

	Yet another one.
*/
package run;

import entity.composite.TextComponent;
import parse.*;
import reader.TextFileReader;
import util.TextSorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String filePath;
        try {
            filePath = Paths.get(ClassLoader.getSystemResource("text.txt").toURI()).toString();
        } catch (URISyntaxException | NullPointerException e) {
            logger.error("Не удалось загрузить text.txt из ресурсов", e);
            return;
        }

        logger.info("Начало обработки текста. Файл: {}", filePath);

        TextFileReader reader = new TextFileReader();
        String rawText = reader.read(filePath);

        logger.info("Текст успешно считан. Длина: {} символов", rawText.length());

        ParserHandler paragraphParser = new ParagraphParser();
        ParserHandler sentenceParser = new SentenceParser();
        ParserHandler lexemeParser = new LexemeParser();
        ParserHandler wordParser = new WordParser();

        paragraphParser.setNext(sentenceParser);
        sentenceParser.setNext(lexemeParser);
        lexemeParser.setNext(wordParser);

        TextComponent text = paragraphParser.parse(rawText);
        logger.info("Текст успешно распарсен.");

        System.out.println("Отсортированные предложения по количеству слов:");
        TextSorter.sortSentencesByWordCount(text).forEach(System.out::println);
    }
}
