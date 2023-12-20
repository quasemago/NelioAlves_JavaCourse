package service;

public interface OnlinePaymentService {
    Double paymentFee(Double value);
    Double interest(Double value, Integer months);
}
