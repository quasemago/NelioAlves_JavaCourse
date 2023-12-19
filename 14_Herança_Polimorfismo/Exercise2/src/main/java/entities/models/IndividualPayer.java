package entities.models;

public class IndividualPayer extends TaxPayer {
    private Double healthExpenditures;

    public IndividualPayer() {
        super();
    }

    public IndividualPayer(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        final double taxValue = this.getAnualIncome() > 20000.00 ? 0.25 : 0.15; // 25% or 15%
        return healthExpenditures > 0.0
                ? ((this.getAnualIncome() * taxValue) - (healthExpenditures * 0.5))
                : (this.getAnualIncome() * taxValue);
    }
}
