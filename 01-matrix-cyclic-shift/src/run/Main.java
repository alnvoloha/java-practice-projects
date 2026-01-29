package run;

import java.util.Scanner;
// javadoc -d ../doc -sourcepath . entity\*.java creator\*.java controller\*.java exception\*.java run\*.java
/**
 * 2 вариант Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).
 * декларированный вариант: в классе Matrix я выделила общую логику циклического сдвига строк в отдельный метод shift, который принимает параметры для количества позиций сдвига и направления. Метод cyclicShift теперь вызывает этот общий метод, что уменьшает дублирование кода и делает его более структурированным и читаемым
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите размерность матрицы n:");
            int n = scanner.nextInt();

            entity.Matrix matrix = new entity.Matrix(n, n);
            System.out.println("Выберите метод заполнения: 1 - случайные числа, 2 - ввод с консоли");
            int method = scanner.nextInt();

            if (method == 1) {
                creator.MatrixCreator.fillRandomized(matrix, 0, 10);
            } else {
                creator.MatrixCreator.fillFromConsole(matrix);
            }

            System.out.println("Исходная матрица:");
            System.out.println(matrix);

            System.out.println("Введите количество позиций для сдвига:");
            int k = scanner.nextInt();
            System.out.println("Введите направление сдвига (right, left, up, down):");
            String direction = scanner.next();

            controller.MatrixController.cyclicShift(matrix, k, direction);

            System.out.println("Матрица после сдвига:");
            System.out.println(matrix);


            System.out.println("Разработчик: Волоха");
            System.out.println("Дата получения задания: Среда, 5 Март 2025, 23:59");
            System.out.println("Дата сдачи задания: Среда, 6 Март 2025, 1:00" );
        } catch (exception.MatrixException e) {
            System.out.println(e.getMessage());
        }
    }
}