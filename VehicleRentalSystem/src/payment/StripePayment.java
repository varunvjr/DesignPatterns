package payment;

public class StripePayment implements PaymentProcessor{
    @Override
    public double processPayment(double amount){
        return amount+10.0;
    }
}
