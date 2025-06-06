package Payment;

public class CashPayment implements Payment{
    @Override
    public boolean processPayment(double amount){
        System.out.println("Payment processed by paying cash");
        return true;
    }
}
