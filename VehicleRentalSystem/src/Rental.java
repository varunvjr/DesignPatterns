import Vehicle.Vehicle;
import payment.PaymentProcessor;
import payment.StripePayment;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Rental {
    private static Rental rental;
    private final Map<String, Vehicle>vehicles;
    private final Map<String, Reservation>reservations;
    private final PaymentProcessor paymentProcessor;
    public Rental(){
        vehicles = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        paymentProcessor = new StripePayment();
    }
    public static synchronized Rental getInstance(){
        if(rental==null){
            rental = new Rental();
        }
        return rental;
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.getLicenseNumber(),vehicle);
    }
    public void removeVehicle(String licenseNumber){
        vehicles.remove(licenseNumber);
    }

    public List<Vehicle> searchVehicles(String model, String make, LocalDate startDate, LocalDate endDate){
        List<Vehicle>availableVehicles = new ArrayList<>();
        for(Vehicle vehicle:vehicles.values()){
            if(vehicle.getMake().equalsIgnoreCase(make)&&vehicle.getModel().equalsIgnoreCase(model)){
                if(isVehicleAvailable(vehicle,startDate,endDate)){
                    availableVehicles.add(vehicle);
                }
            }
        }
        return  availableVehicles;
    }
    public boolean isVehicleAvailable(Vehicle vehicle, LocalDate startDate, LocalDate endDate){
        for(Reservation reservation:reservations.values()){
            if(reservation.getVehicle().equals(vehicle)){
                if(startDate.isBefore(reservation.getEndDate())&&endDate.isAfter(reservation.getStartDate()))
                    return false;
            }
        }
        return true;
    }
    public synchronized Reservation makeReservation(Vehicle vehicle, Customer customer,LocalDate startDate, LocalDate endDate){
        if(isVehicleAvailable(vehicle,startDate,endDate)){
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId,vehicle,customer,startDate,endDate);
            reservations.put(reservationId,reservation);
            vehicle.setAvailable(false);
            return reservation;
        }
        return null;
    }
    public synchronized void cancelReservation(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation!=null){
            reservation.getVehicle().setAvailable(true);
        }
    }

    public double processPayment(Reservation reservation){
        return paymentProcessor.processPayment(reservation.calculatePrice());
    }


    private String generateReservationId(){
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }


}
