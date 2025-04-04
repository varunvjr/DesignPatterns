

import vehicleType.*;
public class ParkingLotDemo {
    public static void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle bike = new Bike("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(bike);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unParkVehicle(bike);

        // Display updated availability
        parkingLot.displayAvailability();
    }
}