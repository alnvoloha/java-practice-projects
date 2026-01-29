package entity;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Comparable<Customer>, Serializable, Cloneable {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private String address;
    private String creditCardNumber;
    private String bankAccountNumber;

    public Customer(long id, String lastName, String firstName, String patronymic,
                    String address, String creditCardNumber, String bankAccountNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(long id, String lastName, String firstName, String patronymic) {
        this(id, lastName, firstName, patronymic, "Unknown", "0000-0000-0000-0000", "000000000");
    }

    public long getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }
    public String getAddress() { return address; }
    public String getCreditCardNumber() { return creditCardNumber; }
    public String getBankAccountNumber() { return bankAccountNumber; }

    public void setAddress(String address) { this.address = address; }
    public void setCreditCardNumber(String creditCardNumber) { this.creditCardNumber = creditCardNumber; }
    public void setBankAccountNumber(String bankAccountNumber) { this.bankAccountNumber = bankAccountNumber; }

    @Override
    public int compareTo(Customer other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, name=%s %s %s, address='%s', creditCard='%s', bankAccount='%s'}",
                id, lastName, firstName, patronymic, address, creditCardNumber, bankAccountNumber);
    }
}
