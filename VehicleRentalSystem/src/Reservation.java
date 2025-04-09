import Vehicle.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Reservation {
    private final String reservationId;
    private final Vehicle vehicle;
    private final Customer customer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    public Reservation(String reservationId, Vehicle vehicle, Customer customer, LocalDate startDate,LocalDate endDate){
        this.reservationId = reservationId;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public double calculatePrice(){
        long daysRented = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return vehicle.getRentPerDay() * daysRented;
    }

    public String getReservationId(){
        return reservationId;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public LocalDate getStartDate(){
        return startDate;
    }
    public LocalDate getEndDate(){
        return endDate;
    }
}
