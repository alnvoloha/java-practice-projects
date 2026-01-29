package task;

import exception.InvalidTextException;

import java.util.stream.IntStream;

public class SpiralEncryptor {

    public static String encryptWithStringMethods(String text) {
        if (text == null || text.isBlank()) {
            throw new InvalidTextException("Текст не может быть пустым или null");
        }

        int n = (int) Math.ceil(Math.sqrt(text.length()));
        char[][] table = new char[n][n];

        int index = 0;
        for (int i = 0; i < n && index < text.length(); i++) {
            for (int j = 0; j < n && index < text.length(); j++) {
                table[i][j] = text.charAt(index++);
            }
        }

        table = rotateClockwise(table);
        invertRows(table);
        invertColumns(table);

        return spiralTraverse(table);
    }

    public static String encryptWithStreams(String text) {
        if (text == null || text.isBlank()) {
            throw new InvalidTextException("Текст не может быть пустым или null");
        }

        int size = (int) Math.ceil(Math.sqrt(text.length()));
        char[][] table = new char[size][size];

        char[] textChars = text.toCharArray();

        for (int i = 0; i < size * size; i++) {
            int row = i / size;
            int col = i % size;
            table[row][col] = i < textChars.length ? textChars[i] : '\0';
        }

        table = rotateClockwise(table);
        invertRows(table);
        invertColumns(table);

        return spiralTraverse(table);
    }

    private static char[][] rotateClockwise(char[][] matrix) {
        int n = matrix.length;
        char[][] rotated = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                rotated[j][n - 1 - i] = matrix[i][j];
        return rotated;
    }

    private static void invertRows(char[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            char[] temp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = temp;
        }
    }

    private static void invertColumns(char[][] matrix) {
        int n = matrix[0].length;
        for (int col = 0; col < n; col += 2) {
            if (col + 1 >= n) break;
            for (int row = 0; row < matrix.length; row++) {
                char temp = matrix[row][col];
                matrix[row][col] = matrix[row][col + 1];
                matrix[row][col + 1] = temp;
            }
        }
    }

    private static String spiralTraverse(char[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        StringBuilder sb = new StringBuilder();

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) sb.append(matrix[top][j]);
            top++;
            for (int i = top; i <= bottom; i++) sb.append(matrix[i][right]);
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) sb.append(matrix[bottom][j]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) sb.append(matrix[i][left]);
                left++;
            }
        }

        return sb.toString().replace("\0", "");
    }
}
