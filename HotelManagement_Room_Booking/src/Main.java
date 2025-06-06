import Payment.Payment;
import Payment.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Management Booking");
        HotelManagement hotelManagement = HotelManagement.getInstance();
        Guest guest1 = new Guest("G001","Varun","varun.vjr@gmail.com","123456789");
        Guest guest2 = new Guest("G002","Monica","monica.vjr@gmail.com","223456789");

        Room room1 = new Room("R001",RoomType.SINGLE,RoomStatus.AVAILABLE,200.50);
        Room room2 = new Room("R002",RoomType.DOUBLE,RoomStatus.AVAILABLE,400.99);

        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = checkInDate.plusDays(5);

        LocalDate checkInDate2 = LocalDate.now();
        LocalDate checkOutDate2 = checkInDate2.plusDays(10);



        Payment payment = new CreditCardPayment();
        Payment payment1 = new CashPayment();
        Reservation reservation1 = hotelManagement.bookRoom(guest1,room1,checkInDate,checkOutDate);
        Reservation reservation2 =  hotelManagement.bookRoom(guest2,room2,checkInDate2,checkOutDate2);
        if(reservation1!=null){
            String reservationId = reservation1.getReservationId();
            hotelManagement.checkIn(reservationId);
            //Check out process
            hotelManagement.checkOut(reservationId,payment);
            System.out.println("Checked out: " + reservationId);

        }else{
            System.out.println("Room not available for booking");
        }
        if(reservation2!=null){
            // Cancel Reservation
            String reservationId2 = reservation2.getReservationId();
            hotelManagement.cancelReservation(reservationId2);
            System.out.println("Reservation has been cancelled with id :"+reservationId2);
        }else{
            System.out.println("Room not available for booking");
        }
    }
}