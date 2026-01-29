package exception;

/**
 * исключение для ошибок, связанных с некорректными операциями над матрицами
 * это исключение используется для обработки различных ситуаций, когда операции с матрицами не могут быть выполнены,
 * например:
 * - при попытке получить элемент матрицы по индексам, которые выходят за пределы её размерности
 * - при попытке выполнить циклический сдвиг на отрицательное количество позиций
 */
public class MatrixException extends Exception {
    public MatrixException() {
        super();
    }

    public MatrixException(String message) {
        super(message);
    }

    public MatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatrixException(Throwable cause) {
        super(cause);
    }
}