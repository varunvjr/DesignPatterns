public class Room {
    private final String roomId;
    private final RoomType roomType;
    private RoomStatus roomStatus;
    private final double roomPrice;
    public Room(String roomId,RoomType roomType,RoomStatus roomStatus,double roomPrice){
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.roomPrice = roomPrice;
    }
    public String getRoomId(){
        return roomId;
    }
    public RoomType getType() {
        return roomType;
    }

    public double getPrice() {
        return roomPrice;
    }

    public RoomStatus getStatus() {
        return roomStatus;
    }
    public synchronized void book(){
        if(roomStatus == RoomStatus.AVAILABLE){
            roomStatus = RoomStatus.BOOKED;
        }else{
            throw new IllegalStateException("Room is already booked");
        }
    }
    public synchronized void checkIn(){
        if(roomStatus == RoomStatus.BOOKED){
            roomStatus = RoomStatus.OCCUPIED;
        }else{
            throw new IllegalStateException("Room is not booked");
        }
    }

    public synchronized void checkOut(){
        if(roomStatus == RoomStatus.OCCUPIED){
            roomStatus = RoomStatus.AVAILABLE;
        }else{
            throw new IllegalStateException("Room is not occupied");
        }
    }



}
