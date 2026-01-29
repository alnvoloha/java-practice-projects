package util;

public class TextUtils {
    public static String normalize(String text) {
        return text.replaceAll("\\t+", "\t")       // заменяем множество табуляций одной
                .replaceAll(" +", " ")          // убираем повторяющиеся пробелы
                .replaceAll(" *\n *", "\n")     // убираем пробелы вокруг переводов строки
                .strip();                       // удаляем пробелы в начале и конце
    }
}
