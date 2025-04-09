package Vehicle;

public class Bike extends Vehicle {
    public Bike(int vehicleId, String model,String make, int makeYear,double rentPerDay, VehicleType type){
        super(vehicleId,model,make,type,makeYear,rentPerDay);
    }
}
