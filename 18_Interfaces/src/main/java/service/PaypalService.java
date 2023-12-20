package service;

public class PaypalService implements OnlinePaymentService {
    private final double SIMPLE_INTEREST_VALUE = 0.01; // 1%
    private final double PAYMENT_FEE_VALUE = 0.02; // 2%

    @Override
    public Double paymentFee(Double value) {
        return value * PAYMENT_FEE_VALUE;
    }

    @Override
    public Double interest(Double value, Integer months) {
        return value * SIMPLE_INTEREST_VALUE * months;
    }
}
