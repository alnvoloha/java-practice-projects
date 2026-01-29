package company.create;

import company.entity.Person;
import company.entity.TaxPayer;

public class TaxPayerFactory {
    public static TaxPayer createTaxPayer(String name, String surname, int age, String taxId) {
        return new TaxPayer(new Person(name, surname, age, taxId));
    }
}
