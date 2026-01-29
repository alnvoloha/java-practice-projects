package company.compare;

import company.entity.Tax;

import java.util.Comparator;

public class TaxComparator implements Comparator<Tax> {
    @Override
    public int compare(Tax t1, Tax t2) {
        return Double.compare(t2.getAmount(), t1.getAmount()); // Сортируем по убыванию
    }
}
