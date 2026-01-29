package company.entity;

import company.action.TaxCalculator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaxPayer extends Person implements Serializable {
    private static final long serialVersionUID = 2L;

    private final List<Income> incomes;
    private transient List<Tax> taxes;

    private static int counter = 0;

    public TaxPayer(String name, String surname, int age, String taxId) {
        super(name, surname, age, taxId);
        this.incomes = new ArrayList<>();
        this.taxes = new ArrayList<>();
        counter++;
    }

    public TaxPayer(Person person) {
        super(person.getName(), person.getSurname(), person.getAge(), person.getTaxId());
        this.incomes = new ArrayList<>();
        this.taxes = new ArrayList<>();
        counter++;
    }

    public void addIncome(Income income) {
        if (income != null) incomes.add(income);
    }

    public void calculateTaxes() {
        this.taxes = TaxCalculator.calculateTaxes(incomes);
    }

    public List<Income> getIncomes() {
        return new ArrayList<>(incomes);
    }

    public List<Tax> getTaxes() {
        return taxes == null ? new ArrayList<>() : new ArrayList<Tax>(taxes);
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "person=" + super.toString() +
                ", incomes=" + incomes +
                ", taxes=" + taxes +
                '}';
    }
}