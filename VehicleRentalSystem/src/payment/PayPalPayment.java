package payment;

public class PayPalPayment implements PaymentProcessor{
    @Override
    public double processPayment(double amount){
        return amount+5;
    }
}
