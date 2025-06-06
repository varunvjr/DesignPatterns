import Payment.Payment;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDate;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagement {
    private static HotelManagement instance;
    private final Map<String,Guest>guests;
    private final Map<String,Reservation>reservations;
    private final Map<String,Room>rooms;

    public HotelManagement(){
        guests = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        rooms = new ConcurrentHashMap<>();
    }
    public synchronized static HotelManagement getInstance(){
        if(instance == null){
            instance = new HotelManagement();
        }
        return instance;
    }
    public Guest getGuest(String guestId){
        return guests.get(guestId);
    }

    public Room getRoom(String roomId){
        return rooms.get(roomId);
    }
    public synchronized Reservation bookRoom(Guest guest,Room room,LocalDate checkInData,LocalDate checkOutDate){
        if(room.getStatus() == RoomStatus.AVAILABLE){
            room.book();
            Reservation reservation = new Reservation(guest,room,checkInData,checkOutDate);
            String reservationId = reservation.getReservationId();
            reservations.put(reservationId,reservation);
            return reservation;
        }
        return null;
    }
    public synchronized void cancelReservation(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation!=null){
            reservation.cancelReservation();
            reservations.remove(reservationId);
        }else{
            throw new IllegalStateException("Invalid Reservation or Reservation does not exist");
        }
    }
    public synchronized void checkIn(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation!=null&&reservation.getStatus()==ReservationStatus.CONFIRMED){
            reservation.getRoom().checkIn();
        }else{
            throw new IllegalStateException("Invalid Reservation or reservation not confirmed");
        }
    }
    public synchronized void checkOut(String reservationId, Payment payment){
        Reservation reservation = reservations.get(reservationId);
        if(reservation!=null&&reservation.getStatus()==ReservationStatus.CONFIRMED){
            Room room = reservation.getRoom();
            double amount = room.getPrice()* ChronoUnit.DAYS.between(reservation.getCheckInDate(),reservation.getCheckoutDate());
            if(payment.processPayment(amount)){
                room.checkOut();
                reservations.remove(reservationId);
            }else{
                throw new IllegalStateException("Payment did not go through");
            }
        }else{
            throw new IllegalStateException("Reservation does not exists");
        }

    }


}
