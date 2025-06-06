package Payment;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount){
        System.out.println("Processing payment using Credit Card of amount: "+amount);
        return true;
    }
}
