public class VisaPayment implements Payment{
    @Override
    public double processTransaction(double amount){
        return amount+10.0;
    }
}
