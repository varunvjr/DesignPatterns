package PaymentGateway;

public class StripePayment extends PaymentProcessor{

    private int extraSurCharge = 10;
    public double includeSurcharge(double amount){
        return amount+extraSurCharge;
    }
    public void pay(double amount){
        amount = includeSurcharge(amount);
        System.out.println("Payment is made through stripe with applicable surcharge :"+amount);
    }
}
