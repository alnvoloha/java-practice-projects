
package valid;

public class IPValidator {
    /**
     * Проверка корректности IPv4-адреса (пример: 192.168.0.1).
     */

    public static boolean isValid(String ip) {
        return ip != null && ip.matches("\\d{1,3}(\\.\\d{1,3}){3}");
    }
}