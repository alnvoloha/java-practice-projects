
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        double a = getNumber(scanner, "Введите первое число:");
        char operator = getOperator(scanner);
        double b = getNumber(scanner, "Введите второе число:");

        double result = calculate(calculator, a, b, operator);
        logger.info("Финальный результат: {}", result);
        System.out.println("Результат: " + result);
        logger.info("Желаете продолжить? -да/-нет");
        String answer = scanner.next().trim().toLowerCase();
        if(answer.equals("да")){
main(args);
        }

    }

    private static double getNumber(Scanner scanner, String message) {
        logger.info(message);
        while (!scanner.hasNextDouble()) {
            logger.warn("Ошибка ввода! Введите число.");
            scanner.next(); //очситка сканера
        }
        return scanner.nextDouble();
    }

    private static char getOperator(Scanner scanner) {
        logger.info("Введите оператор (+, -, *, /):");
        while (true) {
            String input = scanner.next();
            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0);
            }
            logger.warn("Неверный оператор: {}. Введите +, -, * или /", input);
        }
    }

    private static double calculate(Calculator calculator, double a, double b, char operator) {
        switch (operator) {
            case '+': return calculator.add(a, b);
            case '-': return calculator.subtract(a, b);
            case '*': return calculator.multiply(a, b);
            case '/': return calculator.divide(a, b);
            default:
                logger.error("Неизвестный оператор: {}", operator);
                throw new IllegalArgumentException("Неверный оператор.");
        }
    }
}
