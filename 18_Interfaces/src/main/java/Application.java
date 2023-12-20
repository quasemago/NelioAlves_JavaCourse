import model.Contract;
import model.Installment;
import service.ContractService;
import service.PaypalService;
import util.Util;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        // Read contract.
        System.out.println("Enter the contract data:");
        System.out.print("Number: ");
        final int number = sc.nextInt();

        System.out.print("Date (dd/mm/yyyy): ");
        final LocalDate date = LocalDate.parse(sc.next(), Util.CONTRACT_DATE_FORMAT);

        System.out.print("Contract value: ");
        final double crValue = sc.nextDouble();

        final Contract contract = new Contract(number, date, crValue);

        // Read installments.
        System.out.print("Number of installments: ");
        final int installmentsCount = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installmentsCount);

        // Get installments.
        System.out.println("\nInstallments:");
        final List<Installment> contractInstallments = contract.getInstallments();
        for (Installment installment : contractInstallments) {
            System.out.println(installment);
        }

        sc.close();
    }
}
