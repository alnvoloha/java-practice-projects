package unit;

import entity.Payment;
/**
 * Класс PaymentCalculator предоставляет методы для вычисления итоговых данных покупки:
 * общей суммы и количества всех товаров.
 */

public class PaymentCalculator {
    /**
     * Класс PaymentCalculator предоставляет методы для вычисления итоговых данных покупки:
     * общей суммы и количества всех товаров.
     */

    public static double calculateTotalAmount(Payment payment) {
        return payment.getItems().stream()
                .mapToDouble(item -> item.price() * item.quantity())
                .sum(); // Пройдись по всем товарам, умножь цену на количество, сложи всё
    }
    /**
     * Вычисляет общее количество единиц товара в покупке.
     * @param payment объект Payment
     * @return сумма quantity всех товаров
     */

    public static int calculateTotalQuantity(Payment payment) {
        return payment.getItems().stream()
                .mapToInt(Payment.Item::quantity)
                .sum();
    }
}
