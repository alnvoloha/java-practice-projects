package entity;

import exception.MatrixException;

import java.util.Arrays;

/**
 * Класс, представляющий матрицу и предоставляющий методы для работы с элементами матрицы.
 * Он позволяет создавать матрицы из двумерных массивов или по заданным размерам.
 */
public class Matrix {
    private double[][] a;

    /**
     * Конструктор, создающий матрицу из двумерного массива.
     *
     * @param a двумерный массив, представляющий матрицу
     */
    public Matrix(double[][] a) {
        this.a = Arrays.copyOf(a, a.length);
    }

    /**
     * Конструктор, создающий матрицу заданной размерности.
     *
     * @param n количество строк матрицы
     * @param m количество столбцов матрицы
     * @throws MatrixException если размеры матрицы некорректны (меньше 1)
     */
    public Matrix(int n, int m) throws MatrixException {
        if (n < 1 || m < 1) {
            throw new MatrixException("Недопустимые размеры матрицы.");
        }
        a = new double[n][m];
    }

    /**
     * Получает двумерный массив матрицы.
     *
     * @return копия двумерного массива, представляющего матрицу
     */
    public double[][] getMatrix() {
        return Arrays.copyOf(this.a, this.a.length);
    }

    /**
     * Получает количество строк в матрице.
     *
     * @return количество строк
     */
    public int getVerticalSize() {
        return a.length;
    }

    /**
     * Получает количество столбцов в матрице.
     *
     * @return количество столбцов
     */
    public int getHorizontalSize() {
        return a[0].length;
    }

    /**
     * Получает элемент матрицы по индексам.
     *
     * @param i индекс строки
     * @param j индекс столбца
     * @return значение элемента
     * @throws MatrixException если индексы вне диапазона
     */
    public double getElement(int i, int j) throws MatrixException {
        if (checkRange(i, j)) {
            return a[i][j];
        }
        throw new MatrixException("Индекс вне диапазона.");
    }

    /**
     * Устанавливает значение элемента матрицы по индексам.
     *
     * @param i индекс строки
     * @param j индекс столбца
     * @param value новое значение элемента
     * @throws MatrixException если индексы вне диапазона
     */
    public void setElement(int i, int j, double value) throws MatrixException {
        if (checkRange(i, j)) {
            a[i][j] = value;
        } else {
            throw new MatrixException("Индекс вне диапазона.");
        }
    }

    /**
     * Возвращает строковое представление матрицы в виде текстового блока.
     *
     * @return строка, представляющая матрицу
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (double[] row : a) {
            for (double value : row) {
                s.append(String.format("%6.2f ", value));
            }
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Циклический сдвиг строк матрицы.
     *
     * @param k количество позиций для сдвига
     * @param direction направление сдвига ("right" или "left")
     */
    public void cyclicShift(int k, String direction) {
        if (direction.equals("right")) {
            shift(k, 0, 1);
        } else if (direction.equals("left")) {
            shift(k, 0, -1);
        } else {
            throw new IllegalArgumentException("Некорректное направление сдвига.");
        }
    }

    /**
     * Общий метод для циклического сдвига строк матрицы.
     *
     * @param k количество позиций для сдвига
     * @param rowDelta изменение индекса строки
     * @param colDelta изменение индекса столбца
     */
    private void shift(int k, int rowDelta, int colDelta) {
        int n = a.length;
        int m = a[0].length;

        for (int i = 0; i < n; i++) {
            double[] temp = new double[m];
            for (int j = 0; j < m; j++) {
                temp[(j + colDelta * k + m) % m] = a[i][j];
            }
            a[i] = temp;
        }
    }

    /**
     * Проверяет, находятся ли индексы в допустимом диапазоне.
     *
     * @param i индекс строки
     * @param j индекс столбца
     * @return true, если индексы в диапазоне, иначе false
     */
    private boolean checkRange(int i, int j) {
        return (i >= 0 && i < a.length && j >= 0 && j < a[0].length);
    }
}