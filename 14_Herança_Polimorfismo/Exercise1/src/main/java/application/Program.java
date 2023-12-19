package application;

import entities.models.ImportedProduct;
import entities.models.Product;
import entities.models.UsedProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        // Registering products.
        System.out.print("Enter the number of products: ");
        final int numberProducts = sc.nextInt();

        List<Product> productList = new ArrayList<>();

        System.out.println();
        for (int i = 1; i <= numberProducts; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            final char type = sc.next().charAt(0);

            System.out.print("Name: ");
            final String name = sc.next();

            System.out.print("Price: ");
            final double price = sc.nextDouble();

            Product product;

            if (type == 'c') { // Common product.
                product = new Product(name, price);
            } else if (type == 'u') { // Used product.
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                final String manufactureDate = sc.next();

                product = new UsedProduct(name, price, LocalDate.parse(manufactureDate, Utils.MANUFACTURE_DATE_FORMAT));
            } else if (type == 'i') { // Imported product.
                System.out.print("Customs fee: ");
                final double customsFee = sc.nextDouble();

                product = new ImportedProduct(name, price, customsFee);
            } else {
                throw new IllegalArgumentException("Invalid type of product.");
            }

            productList.add(product);
        }

        // Reading products.
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product product : productList) {
            System.out.println(product.priceTag());
        }
    }
}
