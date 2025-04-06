import java.util.*;
public class ElevatorController {
    private final List<Elevator>elevatorList;
    public ElevatorController(int numElevators,int capacity){ // Indicates total number of elevator each of given capacity
        elevatorList = new ArrayList<>();
        for(int i=1;i<=numElevators;i++){
            Elevator elevator = new Elevator(i,capacity);
            elevatorList.add(elevator);
            new Thread(elevator::run).start();
        }
    }
    public void requestElevator(int sourceFloor,int destinationFloor){
        Elevator optimalElevator = findClosestElevator(sourceFloor);
        optimalElevator.addRequest(new Request(sourceFloor,destinationFloor));
    }
    private final Elevator findClosestElevator(int sourceFloor){
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevator:elevatorList){
            int distance = Math.abs(sourceFloor-elevator.getCurrentFloor());
            if(distance<minDistance){
                optimalElevator = elevator;
                minDistance = distance;
            }
        }
        return optimalElevator;
    }

}
