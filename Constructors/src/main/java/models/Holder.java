package models;

public class Holder {
    private static final double TAX = 5.00;

    private int accountNumber;
    private String name;
    private double balance;

    public Holder(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public Holder(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount + TAX;
    }

    @Override
    public String toString() {
        return "Account " + accountNumber
                + ", Holder: " + name
                + ", Balance: $ " + String.format("%.2f", balance);
    }
}
