package model;

public class Product {
    private String name;
    private Double price;
    private Integer count;

    public Product() {
    }

    public Product(String name, Double price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalPrice() {
        return getPrice() * getCount();
    }

    @Override
    public String toString() {
        return getName() + ", $" + String.format("%.2f", getPrice()) + ", " + getCount();
    }
}
