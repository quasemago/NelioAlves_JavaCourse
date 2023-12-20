package model;

import enums.BankAccountErrorCodeEnum;
import handler.BankAccountException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) throws BankAccountException {
        if (amount > withdrawLimit) {
            throw new BankAccountException(BankAccountErrorCodeEnum.ERR001);
        }
        if (amount > balance) {
            throw new BankAccountException(BankAccountErrorCodeEnum.ERR002);
        }
        balance -= amount;
    }
}
