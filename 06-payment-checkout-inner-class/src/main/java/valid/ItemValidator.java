package valid;
/**
 * Класс ItemValidator проверяет валидность данных товара.
 */

public class ItemValidator {
    /**
     * Проверяет, являются ли имя, цена и количество товара допустимыми.
     * @param name название товара
     * @param price цена товара (должна быть >= 0)
     * @param quantity количество товара (должно быть > 0)
     * @return true, если все параметры валидны
     */

    public static boolean isValid(String name, double price, int quantity) {
        return name != null && !name.isBlank() && price >= 0 && quantity > 0;
    }
}
