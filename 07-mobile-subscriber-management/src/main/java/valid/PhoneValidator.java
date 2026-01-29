package valid;

public class PhoneValidator {
    /**
     * Проверка валидности телефонного номера по формату 375XXXXXXXXX.
     */

    public static boolean isValid(String phone) {
        return phone != null && phone.matches("375\\d{9}");
    }
}