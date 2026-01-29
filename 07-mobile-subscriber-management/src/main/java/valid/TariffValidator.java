package valid;

public class TariffValidator {
    /**
     * Проверка валидности тарифного плана — не пустой и не null.
     */

    public static boolean isValid(String tariff) {
        return tariff != null && !tariff.isBlank();
    }
}