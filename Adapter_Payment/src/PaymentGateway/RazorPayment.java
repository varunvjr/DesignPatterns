package PaymentGateway;

public class RazorPayment extends PaymentProcessor {
    private int extraSurCharge = 20;
    public double includeSurcharge(double amount){
        return amount+extraSurCharge;
    }
    public void pay(double amount){
        amount = includeSurcharge(amount);
        System.out.println("Payment made through razor pay :"+amount);
    }
}
