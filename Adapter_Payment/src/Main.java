import java.util.Scanner;
import PaymentGateway.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Payment Gateway");
        System.out.println("Enter your payment gateway");
        Scanner sc = new Scanner(System.in);
        String paymentGateway =  sc.next();
        TransactionGateway gateway = new TransactionGateway();
        PaymentProcessor paymentObject = gateway.transactionType(paymentGateway);
        if(paymentObject==null){
            System.out.println("Invalid payment option");
            System.exit(0);
        }
        System.out.println("Enter the final amount");
        double amount = sc.nextDouble();
        paymentObject.pay(amount);
        System.out.println("Payment has been completed");


    }
}