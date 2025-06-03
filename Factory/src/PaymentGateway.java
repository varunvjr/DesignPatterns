public class PaymentGateway {

    public Payment payment;
    public Payment managePayment(String paymentMethod){
        if(paymentMethod.equalsIgnoreCase("stripe")){
            payment = new StripePayment();
        }else if(paymentMethod.equalsIgnoreCase("visa")){
            payment = new VisaPayment();
        }else{
            throw new RuntimeException("Invalid Payment method");
        }
        return payment;
    }

}
