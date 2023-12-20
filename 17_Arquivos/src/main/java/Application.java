import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        System.out.print("Enter CSV file path: ");
        final String sourceCSVPath = sc.next();

        // Read Input File.
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourceCSVPath))) {
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(","); // name, price, count
                products.add(new Product(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2])));
                line = br.readLine();
            }
        } catch (IOException e) {
           System.out.println("Read Error: " + e.getMessage());
        }

        // Write Output File.
        final String outputPath = new File(sourceCSVPath).getParent() + "/out/";

        // Make sure the output folder has been created.
        if (new File(outputPath).mkdirs()) {
            final String outCSVPath =  outputPath + "/summary.csv";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outCSVPath))) {
                for (Product product : products) {
                    bw.write(String.format("%s,%.2f", product.getName(), product.getPrice()*product.getCount()));
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Write Error: " + e.getMessage());
            }
        } else {
            System.out.println("Unable to create output directory");
        }

        sc.close();
    }
}