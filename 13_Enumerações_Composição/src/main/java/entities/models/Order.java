package entities.models;

import application.Utils;
import entities.enums.OrderStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Client client;
    private Instant date;
    private OrderStatus status;
    private final List<OrderItem> orderItems = new ArrayList<>();

    public Order() {
    }

    public Order(Client client, Instant date, OrderStatus status) {
        this.client = client;
        this.date = date;
        this.status = status;
    }

    public Client getClient() {
        return client;
    }
    public Instant getDate() {
        return date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public double total() {
        double sum = 0.0;
        for (OrderItem item : orderItems) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        final StringBuilder sbItems = new StringBuilder();
        for (OrderItem item : orderItems) {
            sbItems.append(item).append("\n");
        }
        return "ORDER SUMMARY:\n" +
                "Order moment: " + Utils.ORDER_DATE_FORMAT.format(date) + "\n" +
                "Order status: " + status + "\n" +
                "Client: " + client + "\n" +
                "Order items:\n" +
                sbItems +
                "Total price: $" + String.format("%.2f", total());
    }
}
