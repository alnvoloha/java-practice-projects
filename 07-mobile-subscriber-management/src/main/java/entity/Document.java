package entity;

import java.time.LocalDate;

public class Document {
    private final String type;
    private final double amount;
    private final LocalDate date;
    /**
     * Класс для хранения одной транзакции (тип, сумма, дата).
     * Используется внутри абонента для истории платежей.
     */

    public Document(String type, double amount, LocalDate date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date + " | " + type + " | " + amount + " BYN";
    }
}