package entities.models;

public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return this.customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalPrice() {
        return this.getPrice() + customsFee;
    }

    @Override
    public String priceTag() {
        return String.format("%s (used) $ %.2f (Customs fee: $ %.2f)",
                this.getName(),
                this.totalPrice(),
                customsFee);
    }
}
