import java.time.LocalDate;
import java.util.UUID;
public class Reservation {
    private final String reservationId;
    private final Guest guest;
    private ReservationStatus status;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkoutDate;

    public Reservation(Guest guest,Room room, LocalDate checkInDate, LocalDate checkoutDate){
        reservationId = UUID.randomUUID().toString().substring(0,8);
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkoutDate = checkoutDate;
        status = ReservationStatus.CONFIRMED;
    }
    public String getReservationId(){
        return reservationId;
    }
    public LocalDate getCheckInDate(){
        return checkInDate;
    }
    public LocalDate getCheckoutDate(){
        return checkoutDate;
    }
    public Guest getGuest(){
        return guest;
    }
    public Room getRoom(){
        return room;
    }
    public ReservationStatus getStatus(){
        return status;
    }

    public synchronized void cancelReservation() {
        if (status == ReservationStatus.CONFIRMED) {
            status = ReservationStatus.CANCELLED;
        } else {
            throw new IllegalStateException("Room is not confirmed");
        }
    }
}
