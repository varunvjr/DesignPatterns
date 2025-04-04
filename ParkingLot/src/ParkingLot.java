import vehicleType.Vehicle;

import java.util.*;
public class ParkingLot {
    private List<Level>levels;
    private static ParkingLot instance;
    public ParkingLot(){
        levels = new ArrayList<>();
    }
    public static synchronized ParkingLot getInstance(){
        if(instance==null){
            instance = new ParkingLot();
        }
        return instance;
    }
    public void addLevel(Level level){
        levels.add(level);
    }
    public boolean parkVehicle(Vehicle vehicle){
        for(Level level:levels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle has been successfully parked");
                return true;
            }
        }
        System.out.println("Could not park the Vehicle");
        return false;
    }
    public boolean unParkVehicle(Vehicle vehicle){
        for(Level level:levels){
            if(level.unParkVehicle(vehicle)){
                System.out.println("Vehicle has been removed from the parking space");
                return  true;
            }
        }
        return  false;
    }
    public void displayAvailability(){
        for(Level level:levels){
            level.displayAvailability();
        }
    }
}
