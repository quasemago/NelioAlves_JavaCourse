package entities.models;

public class CompanyPayer extends TaxPayer {
    private Integer employeesCount;

    public CompanyPayer() {
        super();
    }

    public CompanyPayer(String name, Double anualIncome, Integer employeesCount) {
        super(name, anualIncome);
        this.employeesCount = employeesCount;
    }

    @Override
    public Double tax() {
        final double taxValue = employeesCount > 10 ? 0.14 : 0.16; // 14% or 16%
        return this.getAnualIncome() * taxValue;
    }
}
