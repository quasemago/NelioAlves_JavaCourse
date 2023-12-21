import model.Product;
import service.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        final String csvPath = "C:\\temp\\input.csv";
        final List<Product> products = new ArrayList<>();

        // Read CSV File.
        try (BufferedReader bf = new BufferedReader(new FileReader(csvPath))) {
            String line = bf.readLine();
            while (line != null) {
                final String[] parts = line.split(",");
                products.add(new Product(parts[0], Double.parseDouble(parts[1])));
                line = bf.readLine();
            }

            // Calculate the most expensive product.
            final Product product = CalculationService.getMostExpensiveItem(products);
            System.out.println("Most Expensive:\n" + product);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
