package company.entity;

public class Income {
    public enum IncomeType {
        MAIN_JOB, SECOND_JOB, AUTHOR_REWARD, PROPERTY_SALE, GIFT, FOREIGN_TRANSFER
    }

    private final IncomeType type;
    private final double amount;
    private final boolean isTaxExempt;

    public Income(IncomeType type, double amount, boolean isTaxExempt) {
        this.type = type;
        this.amount = (amount >= 0) ? amount : 0.0;
        this.isTaxExempt = isTaxExempt;
    }

    public IncomeType getType() { return type; }
    public double getAmount() { return amount; }
    public boolean isTaxExempt() { return isTaxExempt; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Income{type=").append(type)
                .append(", amount=").append(amount)
                .append(", taxExempt=").append(isTaxExempt)
                .append("}")
                .toString();
    }
}
