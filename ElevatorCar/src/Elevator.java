import java.util.*;
public class Elevator {
    private final int elevatorId;
    private int currentFloor;
    private Direction currentDirection;
    private List<Request> requestList;
    private final int capacity;

    public Elevator(int elevatorId,int capacity){
        this.elevatorId = elevatorId;
        this.capacity = capacity;
        this.requestList = new ArrayList<>();
        this.currentDirection = Direction.UP;
        this.currentFloor = 1;
    }

    public synchronized void addRequest(Request request){
        if(requestList.size()<capacity){
            requestList.add(request);
            System.out.println("Elevator :"+elevatorId+" added request: "+request);
            notifyAll();
        }
    }
    public synchronized Request getNextRequest(){
        while (requestList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requestList.remove(0);
    }
    public synchronized  void processRequests(){
        while(true){
            while(!requestList.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void processRequest(Request request){
        int sourceFloor = currentFloor; // Current floor of an elevator
        int destinationFloor = request.getDestinationFloor();
        if(sourceFloor<destinationFloor){
            currentDirection = Direction.UP;
            for(int i=sourceFloor;i<=destinationFloor;i++){
                currentFloor = i;
                System.out.println("Elevator reached :"+currentFloor+" floor");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }else if(sourceFloor>destinationFloor){
            currentDirection = Direction.DOWN;
            for(int i=sourceFloor;i>=destinationFloor;i--){
                currentFloor = i;
                System.out.println("Elevator reached :"+currentFloor+" floor");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void run(){
        processRequests();
    }
    public int getCurrentFloor(){
        return currentFloor;
    }






}
