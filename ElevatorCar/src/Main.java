public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Elevator Car");
        ElevatorController controller = new ElevatorController(5,5);
        controller.requestElevator(1,10);
        controller.requestElevator(5,1);
        controller.requestElevator(3,9);
    }
}