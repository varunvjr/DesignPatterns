import vehicleType.Vehicle;
import vehicleType.VehicleType;

import java.util.*;
public class Level {
    private final List<VehicleSpot>vehicleSpotList;
    private final int floor;
    public Level(int floor,int numSpots){
        this.floor = floor;
        vehicleSpotList = new ArrayList<>(numSpots);
        // Assign spots in ratio of 50:40:10 for bikes, cars,trucks

        int bikeSpots = (int)(numSpots*0.5);
        int carSpots = (int)(numSpots*0.4);
        int truckSpots = (int)(numSpots*0.10);

        for(int i=1;i<=bikeSpots;i++){
            VehicleSpot vehicleSpot = new VehicleSpot(i, VehicleType.BIKE);
            vehicleSpotList.add(vehicleSpot);
        }
        for(int i=bikeSpots+1;i<=bikeSpots+carSpots;i++){
            VehicleSpot vehicleSpot = new VehicleSpot(i,VehicleType.CAR);
            vehicleSpotList.add(vehicleSpot);
        }
        for(int i=bikeSpots+carSpots+1;i<=numSpots;i++){
            VehicleSpot vehicleSpot = new VehicleSpot(i,VehicleType.TRUCK);
            vehicleSpotList.add(vehicleSpot);
        }
    }
    public boolean parkVehicle(Vehicle vehicle){
        for(VehicleSpot spot:vehicleSpotList){
            if(spot.isAvailable()&&spot.getVehicleType().equals(vehicle.getType())){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }
    public boolean unParkVehicle(Vehicle vehicle){
        for(VehicleSpot spot:vehicleSpotList){
            if(!spot.isAvailable()&&spot.getParkedVehicle().equals(vehicle)){
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }
    public void displayAvailability(){
        System.out.println("Level :"+floor +"Availability");
        for(VehicleSpot spot:vehicleSpotList){
            if(spot.isAvailable()){
                System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
            }
        }
    }


}
