package run;

import entity.AnagramChecker;
import entity.WordPair;
import impl.AnagramCheckerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logger.info("Введите первое слово или фразу:");
        String word1 = scanner.nextLine();

        logger.info("Введите второе слово или фразу:");
        String word2 = scanner.nextLine();

        WordPair wordPair = new WordPair(word1, word2);


        AnagramChecker anagramChecker = new AnagramCheckerImpl();
        boolean result = anagramChecker.areAnagrams(wordPair.getWord1(), wordPair.getWord2());

        if (result) {
            logger.info("Слова/фразы являются анаграммами.");
        } else {
            logger.info("Слова/фразы не являются анаграммами.");
        }
    }
}