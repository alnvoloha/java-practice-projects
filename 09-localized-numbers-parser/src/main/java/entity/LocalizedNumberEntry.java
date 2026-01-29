package entity;

import java.math.BigDecimal;
import java.util.Locale;

public class LocalizedNumberEntry {
    private final Locale locale;
    private final BigDecimal value;

    public LocalizedNumberEntry(Locale locale, BigDecimal value) {
        this.locale = locale;
        this.value = value;
    }

    public Locale getLocale() {
        return locale;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Locale: %s, Value: %s", locale, value.toPlainString());
    }
}
