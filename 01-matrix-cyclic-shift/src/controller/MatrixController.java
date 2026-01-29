package controller;

import exception.MatrixException;
import entity.Matrix;

/**
 * Класс, который предоставляет методы для выполнения операций с матрицами, таких как циклический сдвиг.
 */
public class MatrixController {

    /**
     * Выполняет циклический сдвиг матрицы в указанном направлении на k позиций.
     *
     * @param matrix   матрица для сдвига
     * @param k        количество позиций для сдвига
     * @param direction направление сдвига ("right", "left", "up", "down")
     * @throws MatrixException если размерность матрицы некорректна или направление не поддерживается
     */
    public static void cyclicShift(Matrix matrix, int k, String direction) throws MatrixException {
        if (k < 0) {
            throw new MatrixException("Количество позиций для сдвига не может быть отрицательным.");
        }

        int n = matrix.getVerticalSize();
        int m = matrix.getHorizontalSize();
        k = k % (direction.equals("up") || direction.equals("down") ? n : m); // Учитываем только остаток от деления

        switch (direction.toLowerCase()) {
            case "right":
                shiftRight(matrix, k);
                break;
            case "left":
                shiftLeft(matrix, k);
                break;
            case "up":
                shiftUp(matrix, k);
                break;
            case "down":
                shiftDown(matrix, k);
                break;
            default:
                throw new MatrixException("Некорректное направление сдвига.");
        }
    }

    private static void shiftRight(Matrix matrix, int k) throws MatrixException {
        shift(matrix, k, 0, 1);
    }

    private static void shiftLeft(Matrix matrix, int k) throws MatrixException {
        shift(matrix, k, 0, -1);
    }

    private static void shiftUp(Matrix matrix, int k) throws MatrixException {
        shift(matrix, k, -1, 0);
    }

    private static void shiftDown(Matrix matrix, int k) throws MatrixException {
        shift(matrix, k, 1, 0);
    }

    /**
     * Общий метод для обработки циклов и сдвига значений в матрице.
     *
     * @param matrix   матрица для сдвига
     * @param k        количество позиций для сдвига
     * @param rowDelta изменение индекса строки
     * @param colDelta изменение индекса столбца
     */
    private static void shift(Matrix matrix, int k, int rowDelta, int colDelta) throws MatrixException {
        int n = matrix.getVerticalSize();
        int m = matrix.getHorizontalSize();
        double[] temp = new double[n * m];

        // Заполняем временный массив
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i * m + j] = matrix.getElement(i, j);
            }
        }

        // Сдвигаем элементы и записываем обратно
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int newRow = (i + rowDelta * k + n) % n;
                int newCol = (j + colDelta * k + m) % m;
                matrix.setElement(newRow, newCol, temp[i * m + j]);
            }
        }
    }
}