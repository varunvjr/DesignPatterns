package PaymentGateway;
public class TransactionGateway{
    PaymentProcessor gatewayType;
    public PaymentProcessor transactionType(String gateway){
        if(gateway.equalsIgnoreCase("stripe")){
            gatewayType = new StripePayment();
        } else if (gateway.equalsIgnoreCase("razor")) {
            gatewayType = new RazorPayment();
        }else{
            return null;
        }
        return gatewayType;
    }

}
