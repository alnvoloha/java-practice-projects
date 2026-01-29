


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator implements ICalculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    @Override
    public double add(double a, double b) {
        logger.debug("Сложение: {} + {}", a, b);
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        logger.debug("Вычитание: {} - {}", a, b);
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        logger.debug("Умножение: {} * {}", a, b);
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            logger.error("Ошибка: деление на ноль! {} / {}", a, b);
            throw new ArithmeticException("Деление на ноль.");

        }
        logger.debug("Деление: {} / {}", a, b);
        return a / b;
    }
}
