package application;

import models.Holder;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        final Scanner sc = new Scanner(System.in);
        Holder holderAccount;

        System.out.print("Enter account number: ");
        final int accountNumber = sc.nextInt();

        System.out.print("Enter account holder: ");
        sc.nextLine();
        final String name = sc.nextLine();

        System.out.print("Is there an initial deposit? (y/n) ");
        final char deposit = sc.next().charAt(0);

        // Create holder account.
        if (deposit == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialValue = sc.nextDouble();

            holderAccount = new Holder(accountNumber, name, initialValue);
        } else {
            holderAccount = new Holder(accountNumber, name);
        }

        System.out.println("\nAccount data:\n" + holderAccount);
        // Deposit.
        System.out.print("\nEnter a deposit value: ");
        double depositValue = sc.nextDouble();
        holderAccount.deposit(depositValue);

        System.out.println("Updated account data:\n" + holderAccount);

        // Withdraw.
        System.out.print("\nEnter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        holderAccount.withdraw(withdrawValue);

        System.out.println("Updated account data:\n" + holderAccount);
    }
}
