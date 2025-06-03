public class VehicleManagement {
    public static VehicleManagement instance;
    public static VehicleManagement getInstance(){
        if(instance==null){
            instance = new VehicleManagement();
        }
        return instance;
    }
    public void serviceVehicle(){
        System.out.println("Used to service the vehicle");
    }
}
