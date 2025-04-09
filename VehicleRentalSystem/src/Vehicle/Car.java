package Vehicle;
import java.util.UUID;
public class Car extends Vehicle{
    public Car(int vehicleId, String model,String make, int makeYear,double rentPerDay, VehicleType type){
        super(vehicleId,model,make,type,makeYear,rentPerDay);
    }
}
