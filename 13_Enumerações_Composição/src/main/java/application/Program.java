package application;

import entities.enums.OrderStatus;
import entities.models.Client;
import entities.models.Order;
import entities.models.OrderItem;
import entities.models.Product;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Program {
        public static void main(String[] args) {
                Locale.setDefault(Locale.US);
                final Scanner sc = new java.util.Scanner(System.in);

                // Client.
                System.out.println("Enter Client Data:");
                System.out.print("Name: ");
                final String name = sc.nextLine();
                System.out.print("Email: ");
                final String email = sc.nextLine();
                System.out.print("Birth Date (DD/MM/YYYY): ");
                final String birthDate = sc.nextLine();
                final Client client = new Client(name, email, LocalDate.parse(birthDate, Utils.BIRTH_DATE_FORMAT));

                // Order.
                System.out.println();
                System.out.println("Enter Order Data:");
                System.out.print("Status: ");
                final String status = sc.nextLine();
                final Order order = new Order(client, Instant.now(), OrderStatus.valueOf(status));

                // Order Items.
                System.out.print("How many items to this order? ");
                final int n = sc.nextInt();

                for (int i = 1; i <= n; i++) {
                        sc.nextLine(); // clear buffer.
                        System.out.println("Enter #" + i + " item data:");

                        // Product.
                        System.out.print("Product name: ");
                        final String productName = sc.nextLine();
                        System.out.print("Product price: ");
                        final double price = sc.nextDouble();
                        final Product product = new Product(productName, price);

                        // Order Item.
                        System.out.print("Quantity: ");
                        final int quantity = sc.nextInt();
                        final OrderItem orderItem = new OrderItem(quantity, price, product);

                        // Add Order Item to Order.
                        order.addItem(orderItem);
                }

                // Print order.
                System.out.println();
                System.out.println(order);

                sc.close();
        }
}
