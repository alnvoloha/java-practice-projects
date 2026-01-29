import java.io.Console;
import java.util.Scanner;

public class volohaLab213 {
    public static void main(String[] args) {
        Multiplication.switchMultiplication();
    }
}

class Multiplication {
    public static void switchMultiplication() {
        System.out.println("Выбери систему счисления: 2, 8, 10, 16");

        Scanner scanner = new Scanner(System.in);
        int notation = scanner.nextInt();
        scanner.nextLine();

        int size = 10;
        switch (notation) {
            case 2:
                for (int i = 1; i <= size; i++) {
                    for (int j = 1; j <= size; j++) {
                        int result = i * j;
                        String binary = Integer.toBinaryString(result);
                        System.out.printf("%d * %d = %s%n", i, j, binary);
                    }
                }
                break;
            case 8:
                for (int i = 1; i <= size; i++) {
                    for (int j = 1; j <= size; j++) {
                        int result = i * j;
                        String octal = Integer.toOctalString(result);
                        System.out.printf("%d * %d = %s%n", i, j, octal);
                    }
                }
                break;
            case 10:
                for (int i = 1; i <= size; i++) {
                    for (int j = 1; j <= size; j++) {
                        int result = i * j;
                        System.out.println(i + "*" + j + "=" + result);
                    }
                }
                break;
            case 16:
                for (int i = 1; i <= size; i++) {
                    for (int j = 1; j <= size; j++) {
                        int result = i * j;
                        String hex = Integer.toHexString(result);
                        System.out.printf("%d * %d = %s%n", i, j, hex);
                    }
                }
                break;
            default:
                System.out.println("Неверная система счисления.");
                break;
        }

        System.out.println("Хотите продолжить? -да / -нет");
        String continueMulti = scanner.nextLine();

        switch (continueMulti) {
            case "да":
                switchMultiplication();
                break;
            case "нет":
                System.out.println("Выход из программы.");
                break;
        }
    }
}