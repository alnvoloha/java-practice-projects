package company.entity;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private int age;
    private String taxId;

    public Person(String name, String surname, int age, String taxId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.taxId = taxId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getTaxId() {
        return taxId;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", возраст: " + age + ", ИНН: " + taxId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(taxId, person.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, taxId);
    }
}
