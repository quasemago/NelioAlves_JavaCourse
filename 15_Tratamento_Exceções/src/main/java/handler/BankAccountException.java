package handler;

import enums.BankAccountErrorCodeEnum;

public class BankAccountException extends Exception {
    public BankAccountException(BankAccountErrorCodeEnum code) {
        super(code.toString());
    }
}
