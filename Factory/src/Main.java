import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to factory method");
        PaymentGateway paymentGateway = new PaymentGateway();
        System.out.println("Enter the chose of payment gateway");
        String paymentType= sc.nextLine();
        Payment payment = paymentGateway.managePayment(paymentType);
        double amount = payment.processTransaction(200);
        System.out.println("Total amount :"+amount);

    }
}