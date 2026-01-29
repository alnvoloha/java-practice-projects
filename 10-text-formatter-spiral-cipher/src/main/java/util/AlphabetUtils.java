package util;

public class AlphabetUtils {
    public static int getAlphabetIndex(char ch) {
        char lower = Character.toLowerCase(ch);
        return lower - 'a' + 1;
    }
}
