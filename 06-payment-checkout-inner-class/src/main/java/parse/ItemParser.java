package parse;

import entity.Payment;
import exception.InvalidItemException;
import valid.ItemValidator;
/**
 * Класс ItemParser отвечает за разбор строки формата CSV в объект Item.
 * При ошибке формата выбрасывает {@link exception.InvalidItemException}.
 */

public class ItemParser {
    /**
     * Преобразует строку в объект Item, используя указанный объект Payment как контекст.
     * @param line строка формата "name,price,quantity"
     * @param context объект Payment для создания вложенного Item
     * @return объект Item
     * @throws InvalidItemException если строка некорректна или данные не прошли валидацию
     */

    public static Payment.Item parse(String line, Payment context) throws InvalidItemException {
        if (line == null || line.isBlank()) {
            throw new InvalidItemException("Строка пуста или null");
        }

        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new InvalidItemException("Строка должна содержать ровно 3 части: name,price,quantity");
        }

        String name = parts[0].trim();
        double price;
        int quantity;

        try {
            price = Double.parseDouble(parts[1].trim());
            quantity = Integer.parseInt(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new InvalidItemException("Ошибка парсинга чисел", e);
        }

        if (!ItemValidator.isValid(name, price, quantity)) {
            throw new InvalidItemException("Невалидные данные товара: " + line);
        }

        return context.new Item(name, price, quantity);
    }
}
