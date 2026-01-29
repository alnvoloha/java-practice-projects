package util;

import exception.InvalidNumberEntryException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberUtils {
    public static BigDecimal parseLocalizedNumber(String localeStr, String numberStr) throws InvalidNumberEntryException {
        try {
            Locale locale = Locale.forLanguageTag(localeStr.replace('_', '-'));
            NumberFormat format = NumberFormat.getInstance(locale);

            if (format instanceof java.text.DecimalFormat decimalFormat) {
                decimalFormat.setParseBigDecimal(true);
            }

            Number parsed = format.parse(numberStr);

            if (parsed instanceof BigDecimal) {
                return (BigDecimal) parsed;
            } else {
                return new BigDecimal(parsed.toString());
            }

        } catch (IllegalArgumentException | ParseException e) {
            throw new InvalidNumberEntryException("Ошибка разбора числа: " + localeStr + " " + numberStr, e);
        }
    }


}
