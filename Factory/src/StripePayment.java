public class StripePayment implements Payment {
    @Override
    public double processTransaction(double amount){
        return amount+12.50;
    }
}
