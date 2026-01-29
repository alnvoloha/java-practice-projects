package valid;

import java.util.List;

public class OperatorValidator {
    private static final List<String> allowedOperators = List.of("A1", "МТС", "life:)");
    /**
     * Проверка, входит ли оператор в список допустимых (A1, МТС, life:)).
     */

    public static boolean isValid(String operator) {
        return operator != null && allowedOperators.contains(operator);
    }
}