package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/**
 * Класс Payment представляет покупку, состоящую из списка товаров {@link Item}.
 * Позволяет добавлять товары и получать их в виде неизменяемого списка.
 */

public class Payment {

    private final List<Item> items;

    public Payment() {
        this.items = new ArrayList<>();
    }
    /**
     * Добавляет товар в покупку.
     * @param item объект товара
     */

    public void addItem(Item item) {
        this.items.add(item);
    }
    /**
     * Возвращает список всех добавленных товаров.
     * Список является неизменяемым (read-only).
     * @return список товаров
     */

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
    /**
     * Внутренний класс Item представляет товар с названием, ценой и количеством.
     * Является частью конкретного объекта Payment.
     */

    public class Item {
        private final String name;
        private final double price;
        private final int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String name() {
            return name;
        }

        public double price() {
            return price;
        }

        public int quantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append("Item{name='")
                    .append(name)
                    .append("', price=")
                    .append(price)
                    .append(", quantity=")
                    .append(quantity)
                    .append("}")
                    .toString();
        }

        @Override
        public boolean equals(Object o) { // item1.equals(item2)

            if (this == o) return true;
            if (!(o instanceof Item item)) return false;
            return Double.compare(item.price, price) == 0 &&
                    quantity == item.quantity &&
                    Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, quantity);
        }
    }
}
