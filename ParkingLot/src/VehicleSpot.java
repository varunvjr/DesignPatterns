import vehicleType.*;
public class VehicleSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;
    VehicleSpot(int spotNumber,VehicleType type){
        this.spotNumber = spotNumber;
        vehicleType = type;
    }
    public synchronized boolean isAvailable(){
        return parkedVehicle == null;
    }
    public synchronized void parkVehicle(Vehicle vehicle){           // Check is the spot is available for the given vehicle type
        if(isAvailable()&&vehicle.getType()==vehicleType){
            parkedVehicle = vehicle;
        }else{
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied");
        }
    }
    public synchronized void unParkVehicle(){
        parkedVehicle = null;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }
    public int getSpotNumber(){
        return spotNumber;
    }

}
