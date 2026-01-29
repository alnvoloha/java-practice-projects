package company.entity;

public class Tax {
    private final double amount;
    private final String description;
    private final Income relatedIncome;

    public Tax(double amount, String description, Income relatedIncome) {
        this.amount = (amount >= 0) ? amount : 0.0;
        this.description = (description != null) ? description : "Unknown";
        this.relatedIncome = relatedIncome;
    }

    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public Income getRelatedIncome() { return relatedIncome; }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Tax{amount=").append(amount)
                .append(", description='").append(description).append("'")
                .append(", relatedIncome=").append(relatedIncome)
                .append("}")
                .toString();
    }
}
