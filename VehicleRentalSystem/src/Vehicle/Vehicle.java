package Vehicle;

import java.util.UUID;
public class Vehicle {
    private final int vehicleId;
    private final String model;
    private final String make;
    private final VehicleType type;
    private final int makeYear;
    private String licenseNumber;
    private final double rentPerDay;
    private boolean isAvailable;
    public Vehicle(int vehicleId,String model,String make,VehicleType type,int makeYear,double rentPerDay){
        this.vehicleId = vehicleId;
        this.type = type;
        this.model = model;
        this.make = make;
        this.makeYear = makeYear;
        this.licenseNumber = generateLicenseNumber();
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
    }
    public int getVehicleId(){
        return vehicleId;
    }
    public String getModel(){
        return model;
    }
    public String getMake(){
        return make;
    }
    public VehicleType getType(){
        return type;
    }
    public String getLicenseNumber(){
        return licenseNumber;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }
    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable(){
        return isAvailable;
    }
    private String generateLicenseNumber(){
        UUID uuid = UUID.randomUUID();
        this.licenseNumber = uuid.toString().substring(0,8);
        return licenseNumber;
    }

}
