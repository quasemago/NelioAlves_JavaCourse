package service;

import model.Contract;
import model.Installment;

import java.time.LocalDate;

public class ContractService {
    private final OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService service) {
        this.paymentService = service;
    }

    public void processContract(Contract contract, Integer months) {
        // Process contracts.
        final double installmentBaseValue = contract.getTotalValue() / months;
        final LocalDate contractDate = contract.getDate();

        // Calculate interest and fees.
        for (int i = 1; i <= months; i++) {
            double installmentValue = installmentBaseValue + paymentService.interest(installmentBaseValue, i);
            final double paymentFee = paymentService.paymentFee(installmentValue);
            
            installmentValue += paymentFee;
            LocalDate installmentDate = contractDate.plusMonths(i);

            contract.addInstallment(new Installment(installmentDate, installmentValue));
        }
    }
}
