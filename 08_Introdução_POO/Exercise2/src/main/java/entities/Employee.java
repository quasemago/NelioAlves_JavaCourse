package entities;

public class Employee {
    /*
    - Name: string
- GrossSalary: double
- Tax: double
+ NetSalary(): double
+ IncreaseSalary(percentage: double): void
     */
    private String name;
    private double grossSalary;
    private double tax;

    public Employee(String name, double grossSalary, double tax) {
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public double netSalary() {
        return grossSalary - tax;
    }

    public void increaseSalary(double percentage) {
        this.grossSalary += grossSalary * percentage / 100.0;
    }
}
