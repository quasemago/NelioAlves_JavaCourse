package enums;

public enum BankAccountErrorCodeEnum {
    ERR001("001", "The amount exceeds your current withdraw limit."),
    ERR002("002", "Insufficient balance for this operation.");

    private final String code;
    private final String description;

    BankAccountErrorCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getValue() {
        return this.name();
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Error " + code + ": " + description;
    }
}
