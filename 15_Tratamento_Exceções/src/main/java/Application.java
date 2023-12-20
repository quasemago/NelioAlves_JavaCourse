import handler.BankAccountException;
import model.Account;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        // Register account.
        System.out.println("Enter account data");
        System.out.print("Number: ");
        final int number = sc.nextInt();
        System.out.print("Holder: ");
        final String holder = sc.next();
        System.out.print("Initial balance: ");
        final double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        final double withdrawLimit = sc.nextDouble();

        final Account account = new Account(number, holder, initialBalance, withdrawLimit);

        // Account withdraw.
        try {
            System.out.print("\nEnter amount for withdraw: ");
            final double amount = sc.nextDouble();
            account.withdraw(amount);

            System.out.printf("New balance: %.2f", account.getBalance());
        } catch (BankAccountException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
