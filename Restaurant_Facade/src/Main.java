import Restaurant.DeliveryApplication;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the restaurant Service application");
        Scanner sc = new Scanner(System.in);
        DeliveryApplication deliveryApplication = new DeliveryApplication();
        System.out.println("Please enter the restaurant name");
        String restaurantName = sc.nextLine();
        System.out.println("Enter the location of the restaurant");
        String restaurantLocation = sc.nextLine();
        System.out.println("What type of cuisine would you like to have");
        String cuisineType = sc.nextLine();
        System.out.println("What dish would you like to order");
        String dish = sc.nextLine();
        System.out.println("Please enter your choice of payment");
        String paymentType = sc.nextLine();
        System.out.println("Enter the total bill");
        double totalAmount = sc.nextDouble();
        deliveryApplication.processFood(restaurantName,restaurantLocation,cuisineType,dish,paymentType,totalAmount);
        System.out.println("Thank you visit us again");

    }
}