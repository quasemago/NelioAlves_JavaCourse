package application;

import entities.models.CompanyPayer;
import entities.models.IndividualPayer;
import entities.models.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        final int numPayers = sc.nextInt();

        // Register Payers.
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.println();
        for (int i = 1; i <= numPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");
            sc.nextLine(); // clear buffer.

            System.out.print("Individual or Company (i/c): ");
            final char type = sc.next().charAt(0);

            System.out.print("Name: ");
            final String name = sc.next();

            System.out.print("Anual income: ");
            final double income = sc.nextDouble();

            TaxPayer payer;
            if (type == 'i') {
                System.out.print("Health expenditures: ");
                final double healthExp = sc.nextDouble();
                payer = new IndividualPayer(name, income, healthExp);
            } else if (type == 'c') {
                System.out.print("Number of employees: ");
                final int employeesCount = sc.nextInt();
                payer = new CompanyPayer(name, income, employeesCount);
            } else {
                throw new IllegalArgumentException("Invalid type of tax payer.");
            }

            taxPayers.add(payer);
        }

        // Read Payers.
        System.out.println();
        System.out.println("TAXES PAID:");

        double totalTaxes = 0.0;
        for (TaxPayer payer : taxPayers) {
            double tax = payer.tax();
            
            totalTaxes += tax;
            System.out.printf("%s: $ %.2f%n", payer.getName(), tax);
        }

        System.out.println();
        System.out.printf("TOTAL TAXES: $ %.2f", totalTaxes);

        sc.close();
    }
}
