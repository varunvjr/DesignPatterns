import Vehicle.*;
import java.util.*;
import java.time.*;
public class Main {
    public static void main(String[] args) {
        Rental rentalSystem = Rental.getInstance();

        // Add cars to the rental system
        Vehicle vehicle = new Car(101,"Toyota", "Camry", 2022, 50.0, VehicleType.CAR);
        rentalSystem.addVehicle(vehicle);
        Vehicle vehicle1 = new Bike(102,"Bajaj", "Pulsar", 2025, 10.0, VehicleType.BIKE);
        rentalSystem.addVehicle(vehicle1);
        // Create customers
        Customer customer1 = new Customer("John Doe", "john@example.com", "DL1234");

        // Make reservations
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Vehicle> availableVehicles = rentalSystem.searchVehicles("Toyota", "Camry", startDate, endDate);
        if (!availableVehicles.isEmpty()) {
            Vehicle selectedVehicle = availableVehicles.get(0);
            Reservation reservation = rentalSystem.makeReservation(selectedVehicle,customer1,startDate,endDate);
            if (reservation != null) {
                double paymentAmount = -1;
                paymentAmount = rentalSystem.processPayment(reservation);
                if (paymentAmount!=-1) {
                    System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId()+" Payment Amount: "+paymentAmount);
                } else {
                    System.out.println("Payment failed. Reservation canceled.");
                    rentalSystem.cancelReservation(reservation.getReservationId());
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No available cars found for the given criteria.");
        }

    }
}