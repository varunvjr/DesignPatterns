package vehicleType;

public class Vehicle {
    protected String licensePlate;
    protected VehicleType type;
    public Vehicle(String licensePlate,VehicleType type){
        this.licensePlate = licensePlate;
        this.type = type;
    }
    public VehicleType getType(){
        return this.type;
    }

}
