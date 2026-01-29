package creator;

import exception.MatrixException;
import entity.Matrix;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс для создания и заполнения матриц случайными значениями или значениями, введёнными пользователем.
 */
public class MatrixCreator {

    /**
     * Заполняет матрицу случайными значениями в заданном диапазоне.
     *
     * @param matrix матрица для заполнения
     * @param start  начальное значение диапазона
     * @param end    конечное значение диапазона
     */
    public static void fillRandomized(Matrix matrix, int start, int end) {
        fillMatrix(matrix, (i, j) -> start + (end - start) * new Random().nextDouble());
    }

    /**
     * Заполняет матрицу значениями, введёнными пользователем с консоли.
     *
     * @param matrix матрица для заполнения
     */
    public static void fillFromConsole(Matrix matrix) {
        Scanner scanner = new Scanner(System.in);
        fillMatrix(matrix, (i, j) -> {
            System.out.print("Введите элемент [" + i + "][" + j + "]: ");
            return scanner.nextDouble();
        });
    }

    /**
     * Общий метод для заполнения матрицы значениями, полученными через переданную функцию.
     *
     * @param matrix матрица для заполнения
     * @param valueProvider функция, возвращающая значение для заданных индексов
     */
    private static void fillMatrix(Matrix matrix, ValueProvider valueProvider) {
        int totalElements = matrix.getVerticalSize() * matrix.getHorizontalSize();
        for (int index = 0; index < totalElements; index++) {
            int i = index / matrix.getHorizontalSize(); // Вычисляем индекс строки
            int j = index % matrix.getHorizontalSize(); // Вычисляем индекс столбца
            try {
                double value = valueProvider.getValue(i, j);
                matrix.setElement(i, j, value);
            } catch (MatrixException e) {
                // Исключение не должно возникнуть здесь
            }
        }
    }

    /**
     * Интерфейс для получения значений.
     */
    @FunctionalInterface
    private interface ValueProvider {
        double getValue(int i, int j);
    }
}